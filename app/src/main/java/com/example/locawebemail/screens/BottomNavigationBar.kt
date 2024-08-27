package com.example.locawebemail.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.locawebemail.R

@Composable
fun BottomNavigationBar(navController: NavController, modifier: Modifier = Modifier) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = Color(0xFF26313C),
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.home), contentDescription = "Home") },
            selected = currentRoute == "Home",
            onClick = { navController.navigate("Home") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.Gray
            )
        )

        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.emai), contentDescription = "Mail") },
            selected = currentRoute == "CaixaDeEntrada",
            onClick = { navController.navigate("CaixaDeEntrada") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.Gray
            )
        )

        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.calendar), contentDescription = "Calendar") },
            selected = currentRoute == "Calendario",
            onClick = { navController.navigate("Calendario") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.Gray
            )
        )
    }
}
