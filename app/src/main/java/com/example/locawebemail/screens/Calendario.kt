package com.example.locawebemail.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calendario(navController: NavController) {
    val calendar = remember { Calendar.getInstance() }
    val dateFormat = SimpleDateFormat("MMMM yyyy", Locale.getDefault())
    val currentMonth = remember { mutableStateOf(dateFormat.format(calendar.time)) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Calendário", fontSize = 20.sp) },
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
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Mês e Ano com setas de navegação
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back), // Adicione o ícone da seta para a esquerda
                    contentDescription = "Previous Month",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            calendar.add(Calendar.MONTH, -1)
                            currentMonth.value = dateFormat.format(calendar.time)
                        }
                )
                Text(
                    text = currentMonth.value,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_forward), // Adicione o ícone da seta para a direita
                    contentDescription = "Next Month",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            calendar.add(Calendar.MONTH, 1)
                            currentMonth.value = dateFormat.format(calendar.time)
                        }
                )
            }

            // Dias da Semana
            val daysOfWeek = listOf("Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab")
            Row(modifier = Modifier.fillMaxWidth()) {
                for (day in daysOfWeek) {
                    Text(
                        text = day,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }
            }

            // Dias do Mês
            calendar.set(Calendar.DAY_OF_MONTH, 1)
            val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
            val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

            Column(modifier = Modifier.fillMaxWidth()) {
                var dayCounter = 1
                for (week in 0..5) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        for (dayOfWeek in 1..7) {
                            if (week == 0 && dayOfWeek < firstDayOfWeek || dayCounter > daysInMonth) {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .aspectRatio(1f)
                                        .background(Color.LightGray)
                                )
                            } else {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .aspectRatio(1f)
                                        .background(MaterialTheme.colorScheme.primary)
                                        .clickable { /* ação ao clicar no dia */ },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = dayCounter.toString(),
                                        color = Color.White,
                                        fontSize = 16.sp
                                    )
                                }
                                dayCounter++
                            }
                        }
                    }
                }
            }
        }
    }
}
