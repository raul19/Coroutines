package com.raul.base.data.net

import android.content.Context
import com.raul.base.data.util.NetworkUtil
import com.raul.base.data.util.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityInterceptor(val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!NetworkUtil.isOnline(context)) {
            throw NoConnectivityException("Not connected to internet.")
        }
        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }
}
