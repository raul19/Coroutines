package com.raul.base.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raul.base.data.dao.SuperHeroDao
import com.raul.base.data.entity.SuperHeroDBEntity

@Database(entities = [(SuperHeroDBEntity::class)], version = 1)
abstract class SuperHeroDatabase : RoomDatabase() {

    abstract fun superHeroDao(): SuperHeroDao
}
