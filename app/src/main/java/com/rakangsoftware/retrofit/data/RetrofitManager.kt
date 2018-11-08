package com.rakangsoftware.retrofit.data

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager {

    companion object {

        private val BASE_URL = "https://jsonplaceholder.typicode.com/"

        private var sRetrofit: Retrofit? = null

        @JvmStatic
        @Synchronized
        fun get(): Retrofit = sRetrofit
            ?: Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder()
                            .setLenient()
                            .create()
                    )
                )
                .build().also { sRetrofit = it }
    }
}

