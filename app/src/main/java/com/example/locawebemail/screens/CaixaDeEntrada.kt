package com.example.locawebemail.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.locawebemail.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaDeEntrada(navController: NavController, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(
                title = { Text("Caixa de entrada", fontSize = 20.sp) },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("Filtro")
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_menu),
                            contentDescription = "Menu",
                            tint = colorResource(id = R.color.red_locaweb)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO: Implement search action */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_search_24),
                            contentDescription = "Search",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.topbar),
                    titleContentColor = Color.White
                )
            )

            // Email list
            EmailList(modifier = Modifier.weight(1f))

            // Spacer to push the BottomNavigationBar to the bottom
            Spacer(modifier = Modifier.height(56.dp))
        }

        // Bottom navigation bar
        BottomNavigationBar(navController, modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun EmailList(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        EmailItem(
            avatarColor = Color(0xFF4CAF50),
            initials = "T",
            sender = "Tester",
            title = "E-mail title",
            summary = "Lorem ipsum dolor sit amet, consectetur",
            time = "10:35"
        )
        EmailItem(
            avatarColor = Color(0xFFF44336),
            initials = "TA",
            sender = "Tester A",
            title = "E-mail title 1",
            summary = "Lorem ipsum dolor sit amet, consectetur",
            time = "Ontem"
        )
        EmailItem(
            avatarColor = Color(0xFF3F51B5),
            initials = "TB",
            sender = "Tester B",
            title = "E-mail title 2",
            summary = "Lorem ipsum dolor sit amet, consectetur",
            time = "Quin"
        )
    }
}

@Composable
fun EmailItem(
    avatarColor: Color,
    initials: String,
    sender: String,
    title: String,
    summary: String,
    time: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(avatarColor, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(text = initials, color = Color.White)
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = sender, fontWeight = FontWeight.Bold)
            Text(text = title, fontWeight = FontWeight.SemiBold)
            Text(text = summary, color = Color.Gray)
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = time, color = Color.Gray)
    }
}
