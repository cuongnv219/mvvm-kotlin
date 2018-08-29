package com.katana.mvvm.data

import android.content.Context
import com.google.gson.JsonObject
import com.katana.mvvm.data.remote.ApiHelper
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Kaz on 09:54 8/28/18
 */
@Singleton
class AppDataManager @Inject constructor(private val apiHelper: ApiHelper, private val context: Context) : DataManager {

    override fun getAllCountry(params: MutableMap<String, String>): Single<JsonObject> {
        return apiHelper.getAllCountry(params)
    }
}