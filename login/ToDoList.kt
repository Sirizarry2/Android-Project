package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import com.example.login.ui.theme.LoginTheme
import androidx.compose.ui.tooling.preview.Preview


data class ToDoItem(val id: Int, val text: String)

class ToDoList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                ToDoListApp()
            }
        }
    }
}

@Composable
fun ToDoListApp() {
    val toDoList by remember { mutableStateOf(mockToDoList.toMutableList()) }
    var newTaskText by remember { mutableStateOf(TextFieldValue()) }

    Column {
        LazyColumn {
            items(toDoList) { toDo ->
                Text(text = toDo.text)
            }
        }

        OutlinedButton(
            onClick = {
                if (newTaskText.text.isNotEmpty()) {
                    toDoList.add(ToDoItem(toDoList.size + 1, newTaskText.text))
                    newTaskText = TextFieldValue()
                }
            },
        ) {
            Text("Add New Task")
        }
    }
}


val mockToDoList = listOf(
    ToDoItem(1, "Task 1"),
    ToDoItem(2, "Task 2"),
    ToDoItem(3, "Task 3")
)


@Preview
@Composable
fun ToDoListPreview() {
    LoginTheme {
        ToDoListApp()
    }
}