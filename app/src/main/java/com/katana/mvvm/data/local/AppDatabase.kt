package com.katana.mvvm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.katana.mvvm.model.Student

/**
 * Created by Kaz on 11:36 2018-12-18
 */
@Database(entities = [Student::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
}