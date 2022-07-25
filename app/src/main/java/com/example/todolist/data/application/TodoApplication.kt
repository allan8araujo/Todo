package com.example.todolist.data.application

import android.app.Application
import com.example.database.TodoDataBase

class TodoApplication : Application() {
    var helperDb: TodoDataBase? = null
        private set

    companion object {
        lateinit var instace: TodoApplication
    }

    override fun onCreate() {
        super.onCreate()
        instace = this
        helperDb = TodoDataBase(this)
    }
}
