package com.novatech.todolist

data class Todo (
    val title: String,
    var isChecked: Boolean = false
)