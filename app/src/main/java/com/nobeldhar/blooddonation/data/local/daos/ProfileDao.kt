package com.nobeldhar.blooddonation.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nobeldhar.blooddonation.data.local.entities.TimeLinePost

@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTimeLinePost(items: List<TimeLinePost>)

    @Query("SELECT * from timeline_post_table ORDER BY id DESC")
    fun getTimeLinePosts(): LiveData<List<TimeLinePost>>

    @Query("DELETE from timeline_post_table")
    fun deleteAllTimeLinePosts()

}