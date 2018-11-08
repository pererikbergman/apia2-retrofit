package com.rakangsoftware.retrofit.utils

data class DataWrapper<T> (
    val code: Int? = null,
    val data: T? = null
)