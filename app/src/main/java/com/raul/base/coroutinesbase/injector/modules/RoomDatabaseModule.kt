package com.raul.base.coroutinesbase.injector.modules

import android.content.Context
import androidx.room.Room
import com.raul.base.data.database.SuperHeroDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomDatabaseModule {

    @Provides
    @Singleton
    fun provideSuperHerDatabase(context: Context): SuperHeroDatabase =
        Room.databaseBuilder(context, SuperHeroDatabase::class.java, "superhero.db").build()
}
