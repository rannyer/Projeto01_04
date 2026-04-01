package com.example.projeto01_04.ui.screens
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projeto01_04.ui.theme.data.ThemeOption
import com.example.projeto01_04.viewmodels.ThemeViewModel


@Composable
fun ThemeScreen(viewModel: ThemeViewModel = viewModel()) {
    val selectedTheme by viewModel.themeFlow.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Selecione o Tema",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        ThemeOption.entries.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { viewModel.updateTheme(option) },
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RadioButton(
                    selected =  selectedTheme == option,
                    onClick = { viewModel.updateTheme(option) }
                )
                Text(
                    text = when(option) {
                        ThemeOption.SYSTEM -> "Sistema"
                        ThemeOption.LIGHT -> "Claro"
                        ThemeOption.DARK -> "Escuro"
                    },
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Botao de Exemplo")
        }




    }
}








