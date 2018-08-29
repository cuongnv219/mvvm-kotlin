package com.katana.mvvm.data.remote

import com.google.gson.JsonObject
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Kaz on 09:55 8/28/18
 */
@Singleton
class AppApiHelper @Inject constructor() : ApiHelper {

    override fun getAllCountry(params: MutableMap<String, String>): Single<JsonObject> {
        params["key"] = ApiEndPoint.API_KEY
        params["part"] = "snippet"
        params["hl"] = "en_us"

        return Rx2AndroidNetworking.get(ApiEndPoint.GET_ALL_COUNTRY)
                .addQueryParameter(params)
                .build()
                .getObjectSingle(JsonObject::class.java);
    }
}
