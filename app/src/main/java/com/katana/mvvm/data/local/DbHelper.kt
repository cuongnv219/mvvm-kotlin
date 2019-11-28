package com.katana.mvvm.data.local

import androidx.lifecycle.LiveData
import com.katana.mvvm.model.Student
import io.reactivex.Observable

/**
 * Created by Kaz on 11:32 2018-12-18
 */
interface DbHelper {

    fun getAllStudent(): LiveData<List<Student>>

    fun insertStudent(student: Student): Observable<Long>

    fun deleteStudent(student: Student): Observable<Boolean>
}