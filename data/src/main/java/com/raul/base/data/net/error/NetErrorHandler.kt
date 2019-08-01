package com.raul.base.data.net.error

import android.content.Context
import com.google.gson.JsonParser
import com.raul.base.data.R
import io.reactivex.Single
import retrofit2.HttpException
import java.io.InputStream

object NetErrorHandler {

    fun <T> mapError(error: Throwable, context: Context): Single<T> {
        val genericMessage = context.getString(R.string.net_error_handler_generic_error)
        val message = when (error) {
            is HttpException -> {
                val errorStream: InputStream = error.response()?.errorBody()?.byteStream()!!
                val jsonParser = JsonParser()
                //val jsonElement = jsonParser.parse(InputStreamReader(errorStream, "UTF-8"))
                //TODO parse jsonElement to a Response to get error
                genericMessage
            }
            else -> genericMessage
        }
        return Single.error(Throwable(message))
    }
}
