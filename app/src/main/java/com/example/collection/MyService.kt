package com.example.collection

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.collection.domain.repository.MyRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * 我們需要使用AndroidEntryPoint註釋這Class因為服務是一個Android組件
 * */
@AndroidEntryPoint
class MyService : Service() {

    /** @Inject 注入Repository */
    @Inject
    lateinit var repository: MyRepository

    override fun onCreate() {
        super.onCreate()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}