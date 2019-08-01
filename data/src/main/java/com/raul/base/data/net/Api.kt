package com.raul.base.data.net

import com.raul.base.domain.entity.net.IdEntity
import com.raul.base.domain.entity.net.Photo
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("{id}")
    suspend fun getID(@Path( "id")id: String) : IdEntity
}
