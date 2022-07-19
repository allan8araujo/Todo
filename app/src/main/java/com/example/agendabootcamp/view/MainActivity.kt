package com.example.agendabootcamp.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendabootcamp.R
import com.example.agendabootcamp.data.application.TodoApplication
import com.example.agendabootcamp.data.model.TodoItem
import com.example.agendabootcamp.view.adapter.TodoAdapter
import com.example.agendabootcamp.viewmodel.ToDoFactory
import com.example.agendabootcamp.viewmodel.ToDosViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val db = TodoApplication.instace.helperDb
    private val viewModel: ToDosViewModel by viewModels {
        ToDoFactory(db)
    }
    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        viewModel.livelist?.observe(this){
            todoAdapter.deleteAllTodos()
            todoAdapter.addAllTodos(it)
        }

        btnAddTodoList.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            viewModel.insertItem(TodoItem(todoTitle, false))
            if (todoTitle.isNotEmpty()) {
                val todo = TodoItem(todoTitle, false)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }

        btnDeleteTodoList.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}
