package com.nobeldhar.blooddonation.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nobeldhar.blooddonation.data.local.entities.City
import com.nobeldhar.blooddonation.data.local.entities.District
import com.nobeldhar.blooddonation.data.local.entities.Upazilla

@Dao
interface AddressDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDistricts(items: List<District>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThanas(items: List<Upazilla>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCities(items: List<City>)

    @Query("SELECT * from district_table ORDER BY id ASC")
    fun getDistricts(): LiveData<List<District>>

    @Query("SELECT * from upazilla_table WHERE district_id = :id ORDER BY id ASC")
    fun getThanas(id: Int): LiveData<List<Upazilla>>

    @Query("SELECT * from city_table WHERE thana_id = :id ORDER BY id ASC")
    fun getCites(id: Int): LiveData<List<City>>


}