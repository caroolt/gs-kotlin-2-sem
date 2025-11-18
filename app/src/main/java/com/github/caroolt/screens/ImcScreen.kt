package com.github.caroolt

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ImcScreen(navController: NavController) {
    var nome by remember { mutableStateOf("") }
    var pesoText by remember { mutableStateOf("") }
    var alturaText by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Cálculo de IMC", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.primary,)
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome do Usuário") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedTextColor = MaterialTheme.colorScheme.primary
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = pesoText,
            onValueChange = { pesoText = it.filter { it.isDigit() || it == '.' } },
            label = { Text("Peso (kg)") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedTextColor = MaterialTheme.colorScheme.primary
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = alturaText,
            onValueChange = { alturaText = it.filter { it.isDigit() || it == '.' } },
            label = { Text("Altura (m)") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedTextColor = MaterialTheme.colorScheme.primary
            )
        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val peso = pesoText.toDoubleOrNull()
                val altura = alturaText.toDoubleOrNull()

                if (peso != null && altura != null && altura > 0) {
                    val imc = peso / (altura * altura)
                    resultado = "Olá, $nome! Seu IMC é: %.2f".format(imc)
                } else {
                    resultado = "Por favor, insira valores válidos para peso e altura."
                }
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Calcular IMC")
        }
        Spacer(modifier = Modifier.height(24.dp))

        if (resultado.isNotEmpty()) {
            Text(
                text = resultado,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) {
            Text("Voltar ao Menu")
        }
    }
}
