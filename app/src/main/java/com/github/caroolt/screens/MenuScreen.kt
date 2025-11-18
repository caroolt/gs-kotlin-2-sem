package com.github.caroolt

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun MenuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Menu Principal", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { navController.navigate("imc") },
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) {
            Text("Cálculo de IMC")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("equipe") },
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) {
            Text("Equipe")
        }
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                navController.navigate("login") {
                    popUpTo("login") { inclusive = true }
                }
            },
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) {
            Text("Voltar (Login)")
        }
    }
}
