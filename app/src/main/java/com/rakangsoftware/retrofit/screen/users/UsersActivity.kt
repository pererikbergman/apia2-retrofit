package com.rakangsoftware.retrofit.screen.users

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rakangsoftware.retrofit.R

class UsersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.users_activity)

        val viewModel = ViewModelProviders.of(this, UsersViewModelFactory()).get(UsersViewModel::class.java)

        viewModel.usersLiveData.observe(this, Observer {
            println("Users: ${it?.size}")
        })

        viewModel.errorLiveData.observe(this, Observer {
            println("Error: $it")
        })
    }
}
