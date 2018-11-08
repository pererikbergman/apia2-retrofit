package com.rakangsoftware.retrofit.data.user

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.rakangsoftware.retrofit.data.RetrofitManager
import com.rakangsoftware.retrofit.utils.DataWrapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    private val userAPI = RetrofitManager.get().create(UserServerAPI::class.java)

    fun getAll(): LiveData<DataWrapper<List<User>>> {
        val usersLiveData = MutableLiveData<DataWrapper<List<User>>>()
        userAPI.get().enqueue(
            object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    if (response.isSuccessful) {
                        val users = response.body()
                        usersLiveData.postValue(DataWrapper(data = users, code = response.code()))
                    } else {
                        usersLiveData.postValue(DataWrapper(code = response.code()))
                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    println("Error!?!")
                    usersLiveData.postValue(DataWrapper(code = -1))
                }
            }
        )
        return usersLiveData
    }

}