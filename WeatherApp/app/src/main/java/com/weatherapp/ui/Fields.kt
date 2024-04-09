package com.weatherapp.ui

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun DataField(
    field: String,
    label: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = field,
        label = { Text(text = label) },
        modifier = modifier,
        onValueChange = onTextChange
    )
}

@Composable
fun PasswordField(
    password: String,
    label: String,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = password,
        label = { Text(text = label) },
        modifier = modifier,
        onValueChange = onPasswordChange,
        visualTransformation = PasswordVisualTransformation()
    )
}
