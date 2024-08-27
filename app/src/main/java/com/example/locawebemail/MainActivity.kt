package com.example.locawebemail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
//import androidx.compose.runtime.Composabledentro
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.locawebemail.screens.CaixaDeEntrada
import com.example.locawebemail.screens.Calendario
import com.example.locawebemail.screens.CriarConta
import com.example.locawebemail.screens.Filtro
import com.example.locawebemail.ui.theme.LocaWebEmailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocaWebEmailTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "CriarConta"
                    ) {
                        composable(route = "CriarConta") {
                            CriarConta(navController)
                        }
                        composable(route = "CaixaDeEntrada") {
                            CaixaDeEntrada(navController)
                        }
                        composable(route = "Filtro") {
                            Filtro(navController)
                        }
                        composable(route = "Calendario") {
                            Calendario(navController)
                        }
                    }
                }
            }
        }
    }
}



