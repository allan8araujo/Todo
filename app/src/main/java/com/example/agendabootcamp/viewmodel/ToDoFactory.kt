package com.example.agendabootcamp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.agendabootcamp.data.DataBaseRepository

class ToDoFactory(val db: DataBaseRepository?) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ToDosViewModel(db) as T
    }
}
