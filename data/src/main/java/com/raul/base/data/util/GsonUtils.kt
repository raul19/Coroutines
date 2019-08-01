package com.raul.base.data.util

import com.google.gson.*
import java.lang.reflect.Type

/**
 * Created by eli on 10/01/2018.
 */

object GsonUtils {

    private var gsonBuilder: GsonBuilder = GsonBuilder()
    val gson: Gson by lazy {
        return@lazy gsonBuilder.create()
    }

    fun registerTypeAdapter(type: Type, typeAdapter: Any): GsonUtils {
        gsonBuilder.registerTypeAdapter(type, typeAdapter)
        return this
    }

    fun setFieldNamingPolicy(namingConvention: FieldNamingPolicy): GsonUtils {
        gsonBuilder.setFieldNamingPolicy(namingConvention)
        return this
    }

    fun serialize(`object`: Any) = gson.toJson(`object`)

    fun <T> deserialize(jsonString: JsonElement?, classOfT: Class<T>): T? =
            try {
                gson.fromJson(jsonString, classOfT)
            } catch (e: JsonSyntaxException) {
                null
            }

    fun <T> deserialize(jsonString: String?, classOfT: Class<T>): T? =
            try {
                gson.fromJson(jsonString, classOfT)
            } catch (e: JsonSyntaxException) {
                null
            }

    fun <T> deserialize(jsonString: JsonElement?, type: Type) =
            try {
                gson.fromJson<T>(jsonString, type)
            } catch (e: JsonSyntaxException) {
                null
            }

    fun <T> deserialize(jsonString: String?, type: Type): T? =
            try {
                gson.fromJson<T>(jsonString, type)
            } catch (e: JsonSyntaxException) {
                null
            }
}
