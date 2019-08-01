package com.raul.base.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.raul.base.data.entity.SuperHeroDBEntity

@Dao
abstract class SuperHeroDao : BaseDao<SuperHeroDBEntity>() {

    @Query("SELECT * from super_hero_info  ORDER BY id ASC")
    abstract suspend fun getAllSuperHeros(): List<SuperHeroDBEntity>

    @Query("SELECT * from super_hero_info WHERE id=:id")
    abstract suspend fun getSuperHeroDetail(id: String): SuperHeroDBEntity
}
