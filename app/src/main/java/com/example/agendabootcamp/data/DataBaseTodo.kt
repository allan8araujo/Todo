package com.example.agendabootcamp.data

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.agendabootcamp.data.model.TodoItem

class DataBaseTodo(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        const val DATABASE_NAME = "TodoItems.db"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(DataBaseInfo.SQL_CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        if (p1 != p2) {
            p0?.execSQL(DataBaseInfo.SQL_DROP_TABLE_QUERY)
            onCreate(p0)
        }
    }

    fun saveItem(item: TodoItem) {
        val db = writableDatabase ?: return
        db.execSQL(DatabaseDao().insert(item))
        db.close()
    }

    fun deleteItem(listItem: List<TodoItem>) {
        val db = writableDatabase ?: return
        listItem.forEach { todoItem ->
            db.execSQL(DatabaseDao().delete(todoItem))
        }
        db.close()
    }

    fun searchAllItens(): List<TodoItem> {
        val db = readableDatabase ?: return emptyList()
        val lista = mutableListOf<TodoItem>()
        val cursor: Cursor =
            db.rawQuery(DatabaseDao().listAll(), arrayOf()) ?: return emptyList()
        while (cursor.moveToNext()) {
            val item = TodoItem(
                cursor.getString(cursor.getColumnIndexOrThrow(DataBaseInfo.TableInfo.COLUMN_NAME)),
                false
            )
            lista.add(item)
        }
        db.close()
        return lista
    }
}
