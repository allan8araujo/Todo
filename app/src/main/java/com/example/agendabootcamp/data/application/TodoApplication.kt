package com.example.agendabootcamp.data.application

import android.app.Application
import com.example.agendabootcamp.data.DataBaseRepository

class TodoApplication : Application() {
    var helperDb: DataBaseRepository? = null
        private set

    companion object {
        lateinit var instace: TodoApplication
    }

    override fun onCreate() {
        super.onCreate()
        instace = this
        helperDb = DataBaseRepository(this)
    }
}
