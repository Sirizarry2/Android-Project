package com.example.login

import PreferencesPreview
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.login.ui.theme.LoginTheme
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            LoginTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") {
                            LoginScreen(navController)
                        }
                        composable("to_do_list") {
                            ToDoListScreen()
                        }
                        composable("help") {
                            HelpFragmentContent()
                        }
                        composable("preference") {
                            PreferencesPreview()
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun LoginScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column {
        LoginTextField(label = "Username") { newUsername ->
            username = newUsername
        }
        LoginTextField(label = "Password", isPassword = true) { newPassword ->
            password = newPassword
        }
        LoginButton(navController = navController)
    }
}

@Composable
fun LoginTextField(label: String, isPassword: Boolean = false,  onValueChanged: (String) -> Unit ) {
    var text by remember { mutableStateOf(TextFieldValue()) }

    TextField(
        value = text,
        onValueChange = { text = it
            onValueChanged(it.text)},
        label = { Text(text = label)},
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}


@Composable
fun LoginText(text: String) {
    Text(text = text)
}

@Composable
fun LoginButton(navController: NavController) {
    Column {
        Button(
            onClick = {
                navController.navigate("to_do_list")
            }
        ) {
            Text(text = "To Do List")
        }

        Button(
            onClick = {
                navController.navigate("help")
            }
        ) {
            Text(text = "Help")
        }

        Button(
            onClick = {
                navController.navigate("preference")
            }
        ) {
            Text(text = "Preferences")

        }
    }
}


@Composable
fun ToDoListScreen() {
    Text(text = "To-Do List Screen")
}
@Preview
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    LoginTheme {
        Surface {
            Column {
                LoginText("Username")
                LoginText("Password")
                LoginButton(navController = navController)
            }
        }
    }
}

