package com.raul.base.data.net

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.raul.base.data.util.GsonUtils
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Named

class RestClient @Inject constructor(context: Context, @Named("apiUrl") baseUrl: String,
                                     @Named("buildType") debug: Boolean) {

    companion object {
        private const val TIMEOUT: Long = 50
    }

    val api: Api

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
            .apply { level = HttpLoggingInterceptor.Level.BODY }

        val httpClient = OkHttpClient.Builder()
            .apply {
                connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                readTimeout(TIMEOUT, TimeUnit.SECONDS)

                addInterceptor(loggingInterceptor)
                addInterceptor(ConnectivityInterceptor(context))
                addInterceptor { chain ->
                    val original = chain.request()
                    val request = original.newBuilder()
                        .header("Accept", "application/json")
                        .method(original.method(), original.body())
                        .build()
                    chain.proceed(request)
                }
                addInterceptor(ChuckInterceptor(context))
            }

        val client = httpClient.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonUtils.gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()

        api = retrofit.create(Api::class.java)
    }
}
