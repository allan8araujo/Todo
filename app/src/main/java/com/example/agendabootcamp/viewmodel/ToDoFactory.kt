package com.example.agendabootcamp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.agendabootcamp.data.DataBaseTodo

class ToDoFactory(val db: DataBaseTodo?) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ToDosViewModel(db) as T
    }
}
