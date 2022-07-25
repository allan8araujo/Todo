package com.example.todolist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.abstractions.model.TodoItem

class ToDosViewModel(val db: com.example.database.TodoDataBase?) : ViewModel() {
    private val listFromDB = MutableLiveData<List<TodoItem>>()
    val livelist: LiveData<List<TodoItem>> = listFromDB

    fun insertItem(item: TodoItem) {
        db?.saveItem(item)
    }

    fun searchItem() {
        val listFromDb = db?.searchAllItens()
        listFromDB.value = listFromDb
    }

    fun deleteItem(ListItems: List<TodoItem>) {
        db?.deleteItem(ListItems)
    }
}
