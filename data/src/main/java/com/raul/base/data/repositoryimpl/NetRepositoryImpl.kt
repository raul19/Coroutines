package com.raul.base.data.repositoryimpl

import android.content.Context
import com.raul.base.domain.entity.net.Photo
import com.raul.base.data.net.RestClient
import com.raul.base.data.repository.NetRepository
import com.raul.base.domain.entity.net.IdEntity
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class NetRepositoryImpl @Inject constructor(private val restClient: RestClient,
                                            private val context: Context) : NetRepository {

    override suspend fun getId(id: String) = restClient.api.getID(id)
}
