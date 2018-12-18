package com.katana.mvvm.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.katana.mvvm.model.Student

/**
 * Created by Kaz on 11:36 2018-12-18
 */
@Database(entities = [Student::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
}