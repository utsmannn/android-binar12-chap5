package com.utsman.binarku

import android.app.Service
import android.content.Intent
import android.os.IBinder

class SimpleServices : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        println("BINAR ------> services created!")
    }

}