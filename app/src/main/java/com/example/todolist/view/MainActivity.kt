package com.example.todolist.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abstractions.model.TodoItem
import com.example.todolist.R
import com.example.todolist.data.application.TodoApplication
import com.example.todolist.view.adapter.TodoAdapter
import com.example.todolist.viewmodel.ToDoFactory
import com.example.todolist.viewmodel.ToDosViewModel
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
        viewModel.livelist.observe(this) {
            todoAdapter.addAllTodos(it)
        }
        viewModel.searchItem()

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
            val selectedItems = todoAdapter.listAllTodo()
            viewModel.deleteItem(selectedItems)
            todoAdapter.deleteDoneTodos()
        }
    }
}
