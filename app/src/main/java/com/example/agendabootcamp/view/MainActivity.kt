package com.example.agendabootcamp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendabootcamp.R
import com.example.agendabootcamp.view.adapter.TodoAdapter
import com.example.agendabootcamp.data.model.TodoItem
import com.example.agendabootcamp.data.application.TodoApplication
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAddTodoList.setOnClickListener {
            //TodoApplication.instace.helperDb
            val todoTitle = etTodoTitle.text.toString()
            TodoApplication.instace.helperDb?.saveItem(TodoItem(todoTitle, false))
            if (todoTitle.isNotEmpty()) {
                val todo = TodoItem(todoTitle, false)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }

        btnRefresh.setOnClickListener {
            val listaFiltrada: List<TodoItem>
            try {
                listaFiltrada = TodoApplication.instace.helperDb?.searchItem("") ?: mutableListOf()

                todoAdapter.addAllTodos(listaFiltrada)
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }

        btnDeleteTodoList.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}
