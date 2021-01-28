package com.nobeldhar.blooddonation.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nobeldhar.blooddonation.data.local.converters.ProfileConverter
import com.nobeldhar.blooddonation.data.local.daos.AddressDao
import com.nobeldhar.blooddonation.data.local.daos.DashboardDao
import com.nobeldhar.blooddonation.data.local.daos.ProfileDao
import com.nobeldhar.blooddonation.data.local.entities.*


@Database(entities = [District::class, Upazilla::class, City::class,
    Post::class, TimeLinePost::class, Group::class], version = 1, exportSchema = false)
@TypeConverters(value = [(ProfileConverter::class)])
abstract class OneMinuteHelpDatabase : RoomDatabase() {

    abstract fun addressDao(): AddressDao
    abstract fun profileDao(): ProfileDao
    abstract fun dashboardDao(): DashboardDao
}