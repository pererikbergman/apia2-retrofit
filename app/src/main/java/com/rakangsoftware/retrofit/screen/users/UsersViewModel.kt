package com.rakangsoftware.retrofit.screen.users

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.rakangsoftware.retrofit.data.user.UserRepository

class UsersViewModel(private val repo: UserRepository) : ViewModel() {

    val errorLiveData = MutableLiveData<String>()

    val usersLiveData = Transformations.map(repo.getAll()) {
        if (it.data != null) {
            it.data
        } else {
            errorLiveData.postValue("Something is wrong!!!")
            listOf()
        }

    }
}