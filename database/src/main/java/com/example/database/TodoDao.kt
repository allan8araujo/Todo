package com.example.database

import com.example.abstractions.model.TodoItem

class TodoDao {
    fun insert(item: TodoItem) = "INSERT INTO ${DataBaseInfo.TableInfo.TABLE_NAME}" +
        "(${DataBaseInfo.TableInfo.COLUMN_NAME}) VALUES ('${item.title}')"

    fun delete(item: TodoItem) = "DELETE FROM ${DataBaseInfo.TableInfo.TABLE_NAME}" +
        " WHERE 'TITLE' = '${item.title}'"

    fun listAll() = "SELECT * FROM ${DataBaseInfo.TableInfo.TABLE_NAME}"
}
