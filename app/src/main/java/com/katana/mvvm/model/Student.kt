package com.katana.mvvm.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

/**
 * Created by Kaz on 08:22 8/28/18
 */
@Entity(tableName = "student")
data class Student(@Expose var name: String,
                   @PrimaryKey(autoGenerate = true) @Expose var id: Int?)