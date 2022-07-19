package com.example.agendabootcamp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.agendabootcamp.data.DataBaseRepository
import com.example.agendabootcamp.data.model.TodoItem

class ToDosViewModel(val db: DataBaseRepository) : ViewModel() {
    var livelist: MutableLiveData<MutableList<TodoItem>>? = null

    fun insertItem(item: TodoItem) {
        db.saveItem(item)
    }

    fun searchItem(item: TodoItem) {
        val listFromDb = db.searchItem(item.title)
        livelist?.value = listFromDb.toMutableList()
    }

    fun deleteItem(item: TodoItem) {
        // TODO db.deleteItem(item)
    }
}
