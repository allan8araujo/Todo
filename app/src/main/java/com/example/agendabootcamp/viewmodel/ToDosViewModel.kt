package com.example.agendabootcamp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.agendabootcamp.data.DataBaseTodo
import com.example.agendabootcamp.data.model.TodoItem

class ToDosViewModel(val db: DataBaseTodo?) : ViewModel() {

    val livelist = MutableLiveData<List<TodoItem>>()

    fun insertItem(item: TodoItem) {
        db?.saveItem(item)
    }

    fun searchItem() {
        val listFromDb = db?.searchAllItens()
        livelist.value = listFromDb
        livelist.value?.forEach {
            Log.i(it.title, "")
        }
    }

    fun deleteItem(item: TodoItem) {
        // TODO db.deleteItem(item)
    }
}
