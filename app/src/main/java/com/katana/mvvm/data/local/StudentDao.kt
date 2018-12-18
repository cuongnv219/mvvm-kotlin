package com.katana.mvvm.data.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.katana.mvvm.model.Student

/**
 * Created by Kaz on 11:37 2018-12-18
 */
@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudent(student: Student): Long

    @Query("select * from student")
    fun getAllStudent(): LiveData<List<Student>>

    @Delete
    fun deleteStudent(vararg student: Student)
}