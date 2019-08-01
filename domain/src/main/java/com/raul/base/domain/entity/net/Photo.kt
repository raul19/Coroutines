package com.raul.base.domain.entity.net

import com.raul.base.domain.mapper.BaseDataTransformer
import com.raul.base.domain.models.PhotoModel

class Photo(val albumId: Int, val id: Int, val title: String, val url: String, val thumbnailUrl: String) {

    object EntityMapper : BaseDataTransformer<Photo, PhotoModel>() {
        override fun transform(from: Photo) =
            PhotoModel(from.albumId, from.id, from.title, from.url, from.thumbnailUrl)
    }

    object ModelMapper : BaseDataTransformer<PhotoModel, Photo>() {
        override fun transform(from: PhotoModel) =
            Photo(from.albumId, from.id, from.title, from.url, from.thumbnailUrl)
    }
}
