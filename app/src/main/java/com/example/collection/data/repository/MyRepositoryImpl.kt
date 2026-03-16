package com.example.collection.data.repository

import android.app.Application
import android.util.Log
import com.example.collection.R
import com.example.collection.data.remote.MyApi
import com.example.collection.domain.repository.MyRepository


class MyRepositoryImpl(
    private val api: MyApi,
    private val appContext: Application
) : MyRepository {

    init {
        val appName = appContext.getString(R.string.app_name)
        Log.d("myrepo", "Hello from the repository! The app name is $appName")
    }

    override suspend fun doNetworkCall() {
        TODO("Not yet implemented")
    }
}