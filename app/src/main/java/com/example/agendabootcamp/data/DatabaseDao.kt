package com.example.agendabootcamp.data

import com.example.agendabootcamp.data.model.TodoItem

class DatabaseDao {
    fun insert(item: TodoItem) = "INSERT INTO ${DataBaseInfo.TableInfo.TABLE_NAME}" +
        "(${DataBaseInfo.TableInfo.COLUMN_NAME}) VALUES ('${item.title}')"

    fun listAll() = "SELECT * FROM ${DataBaseInfo.TableInfo.TABLE_NAME}"
}
