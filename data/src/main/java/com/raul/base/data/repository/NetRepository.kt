package com.raul.base.data.repository

import com.raul.base.domain.entity.net.IdEntity
import com.raul.base.domain.entity.net.Photo
import kotlinx.coroutines.Deferred

interface NetRepository {

    suspend fun getId(id: String): IdEntity

}
