package com.weatherapp

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.weatherapp.ui.theme.WeatherAppTheme

class RegisterActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
    setContent {
        RegisterPage()
    }
}
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun RegisterPage(modifier: Modifier = Modifier) {

    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var repeatedPassword by rememberSaveable { mutableStateOf("") }
    val activity = LocalContext.current as? Activity

    Column(
        modifier = Modifier.run { padding(16.dp) },
    ) {
        Text(
            text = "Bem-vindo/a!",
            fontSize = 24.sp
        )
        OutlinedTextField(
            value = name,
            label = { Text(text = "Digite seu nome") },
            modifier = Modifier,
            onValueChange = { name = it }
        )
        OutlinedTextField(
            value = email,
            label = { Text(text = "Digite seu e-mail") },
            modifier = Modifier,
            onValueChange = { email = it }
        )
        OutlinedTextField(
            value = password,
            label = { Text(text = "Digite sua senha") },
            modifier = Modifier,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation()
        )
        OutlinedTextField(
            value = repeatedPassword,
            label = { Text(text = "Repita sua senha") },
            modifier = Modifier,
            onValueChange = { repeatedPassword = it },
            visualTransformation = PasswordVisualTransformation()
        )
        Row(modifier = modifier) {
            Button(
                onClick = {
                    Toast.makeText(activity, "Usuário registrado com sucesso!", Toast.LENGTH_SHORT).show()
                    activity?.finish()
                },
                enabled = name.isNotEmpty()
                    && email.isNotEmpty()
                    && password.isNotEmpty()
                    && repeatedPassword.isNotEmpty()
                    && (password == repeatedPassword)
            ) {
                Text("Registrar")
            }
            Button(
                onClick = { email = ""; password = "" }
            ) {
                Text("Limpar")
            }
        }
    }
}
