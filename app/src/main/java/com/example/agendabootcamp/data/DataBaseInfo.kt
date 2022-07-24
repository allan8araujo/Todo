package com.example.agendabootcamp.data

import android.provider.BaseColumns

object DataBaseInfo {
    const val SQL_CREATE_TABLE_QUERY =
        "CREATE TABLE ${TableInfo.TABLE_NAME}(" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "${TableInfo.COLUMN_NAME} TEXT)"


    const val SQL_DROP_TABLE_QUERY = "DROP TABLE IF EXISTS ${TableInfo.TABLE_NAME}"

    object TableInfo : BaseColumns {
        const val TABLE_NAME = "TodoItemsTable"
        const val COLUMN_NAME = "itemName"
    }
}
