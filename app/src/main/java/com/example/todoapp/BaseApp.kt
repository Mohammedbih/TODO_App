package com.example.todoapp

import android.app.Application
import com.example.todoapp.data.TaskDatabase

class BaseApp: Application() {
    override fun onCreate() {
        super.onCreate()
        TaskDatabase.getInstance(this)
    }
}