package com.novatech.todolist

 import android.os.Bundle
 import android.widget.Button
 import android.widget.EditText
 import androidx.appcompat.app.AppCompatActivity
 import androidx.recyclerview.widget.LinearLayoutManager
 import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf()) // passing in an empty list

        val rvTodoItems = findViewById<RecyclerView>(R.id.rvTodoItems)
        rvTodoItems.adapter = todoAdapter

        rvTodoItems.layoutManager = LinearLayoutManager(this)

        val btnAddTodo = findViewById<Button>(R.id.btnAddTodo)
        btnAddTodo.setOnClickListener {
            val etTodoTitle = findViewById<EditText>(R.id.etTodoTitle)
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }

        val btnDeleteDoneTodos = findViewById<Button>(R.id.btnDeleteDoneTodos)
        btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}