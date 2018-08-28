package com.katana.mvvm.data.remote

import com.google.gson.JsonObject
import io.reactivex.Single

/**
 * Created by Kaz on 09:55 8/28/18
 */
interface ApiHelper {

    fun getAllCountry(params: MutableMap<String, String>): Single<JsonObject>
}