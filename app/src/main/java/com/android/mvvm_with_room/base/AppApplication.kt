package com.android.mvvm_with_room.base

import android.app.Application
import android.content.Context

class AppApplication : Application() {
    companion object{
        private var appContext : Application ?=null
        fun getAppContext():Context {
            return appContext!!.applicationContext
        }
    }
    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}