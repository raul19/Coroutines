package com.raul.base.data.entity.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.raul.base.data.util.GsonUtils
import com.raul.base.domain.models.*

class DataTypeConverter {

    companion object {

        var gson: Gson = Gson()

        @TypeConverter
        fun imageToString(image: ImageModel): String = GsonUtils.serialize(image)

        @TypeConverter
        fun stringToImage(url: String): ImageModel = GsonUtils.deserialize<ImageModel>(url, ImageModel::class.java)
            ?: ImageModel()

        @TypeConverter
        fun powerstatsToString(powerstats: PowerStatsModel): String = GsonUtils.serialize(powerstats)

        @TypeConverter
        fun stringToPowerstats(powerstats: String): PowerStatsModel =
            GsonUtils.deserialize<PowerStatsModel>(powerstats, PowerStatsModel::class.java)
                ?: PowerStatsModel()

        @TypeConverter
        fun biographyToString(biography: BiographyModel): String = GsonUtils.serialize(biography)

        @TypeConverter
        fun stringToBiography(biography: String): BiographyModel =
            GsonUtils.deserialize<BiographyModel>(biography, BiographyModel::class.java)
                ?: BiographyModel()

        @TypeConverter
        fun appearanceToString(appearance: AppearanceModel): String = GsonUtils.serialize(appearance)

        @TypeConverter
        fun stringToAppearance(appearance: String): AppearanceModel =
            GsonUtils.deserialize<AppearanceModel>(appearance, AppearanceModel::class.java)
                ?: AppearanceModel()

        @TypeConverter
        fun workToString(work: WorkModel): String = GsonUtils.serialize(work)

        @TypeConverter
        fun stringToWork(work: String): WorkModel =
            GsonUtils.deserialize<WorkModel>(work, WorkModel::class.java)
                ?: WorkModel()

        @TypeConverter
        fun connectionToString(connection: ConnectionsModel): String = GsonUtils.serialize(connection)

        @TypeConverter
        fun stringToConnection(connection: String): ConnectionsModel =
            GsonUtils.deserialize<ConnectionsModel>(connection, ConnectionsModel::class.java)
                ?: ConnectionsModel()

    }
}
