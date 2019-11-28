package com.katana.mvvm.data.local

import androidx.lifecycle.LiveData
import com.katana.mvvm.model.Student
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Kaz on 11:36 2018-12-18
 */
@Singleton
class AppDbHelper @Inject constructor(private val appDatabase: AppDatabase) : DbHelper {

    override fun getAllStudent(): LiveData<List<Student>> = appDatabase.studentDao().getAllStudent()

    override fun insertStudent(student: Student): Observable<Long> {
        return Observable.fromCallable { appDatabase.studentDao().insertStudent(student) }
    }

    override fun deleteStudent(student: Student): Observable<Boolean> =
            Observable.fromCallable {
                appDatabase.studentDao().deleteStudent(student)
                true
            }
}