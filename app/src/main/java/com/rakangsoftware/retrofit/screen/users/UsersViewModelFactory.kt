package com.rakangsoftware.retrofit.screen.users

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.rakangsoftware.retrofit.data.user.UserRepository

class UsersViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UsersViewModel(UserRepository()) as T
    }
}