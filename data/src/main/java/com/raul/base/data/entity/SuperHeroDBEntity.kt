package com.raul.base.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.raul.base.data.entity.typeconverter.DataTypeConverter
import com.raul.base.domain.models.IdModel

@Entity(tableName = "super_hero_info")
data class SuperHeroDBEntity(
    @PrimaryKey @ColumnInfo(name = "id") var id: String,
    @ColumnInfo(name = "response") var response: String,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "image")
    @TypeConverters(DataTypeConverter::class) var image: String,
    @ColumnInfo(name = "powerstats")
    @TypeConverters(DataTypeConverter::class) var powerstats: String,
    @ColumnInfo(name = "biography")
    @TypeConverters(DataTypeConverter::class) var biography: String,
    @ColumnInfo(name = "appearance")
    @TypeConverters(DataTypeConverter::class) var appearance: String,
    @ColumnInfo(name = "work")
    @TypeConverters(DataTypeConverter::class) var work: String,
    @ColumnInfo(name = "connection")
    @TypeConverters(DataTypeConverter::class) var connection: String
)

fun SuperHeroDBEntity.toModel() = IdModel(
    this.response,
    this.id,
    this.name,
    DataTypeConverter.stringToImage(this.image),
    DataTypeConverter.stringToPowerstats(this.powerstats),
    DataTypeConverter.stringToBiography(this.biography),
    DataTypeConverter.stringToAppearance(this.appearance),
    DataTypeConverter.stringToWork(this.work),
    DataTypeConverter.stringToConnection(this.connection))

fun IdModel.toDbEntity() = SuperHeroDBEntity(
    this.id,
    this.response,
    this.name,
    DataTypeConverter.imageToString(this.image),
    DataTypeConverter.powerstatsToString(this.powerstats),
    DataTypeConverter.biographyToString(this.biography),
    DataTypeConverter.appearanceToString(this.appearance),
    DataTypeConverter.workToString(this.work),
    DataTypeConverter.connectionToString(this.connections))
