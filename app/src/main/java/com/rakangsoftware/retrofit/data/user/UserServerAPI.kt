package com.rakangsoftware.retrofit.data.user

import retrofit2.Call
import retrofit2.http.GET

interface UserServerAPI {

    @GET("users/")
    fun get(): Call<List<User>>
}