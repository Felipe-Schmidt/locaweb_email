package com.example.locawebemail.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.locawebemail.R

@Composable
fun Filtro(navController: NavController) {


    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(16.dp)) {

        Text(text = "Filtro", fontSize = 24.sp, color = Color.Black, modifier = Modifier.padding(bottom = 16.dp))

        FilterItem(iconId = R.drawable.emai, label = "Todas as mensagens")
        FilterItem(iconId = R.drawable.unread, label = "Não lidas")
        FilterItem(iconId = R.drawable.delete, label = "Lixeira")
        FilterItem(iconId = R.drawable.draw, label = "Rascunho")
        FilterItem(iconId = R.drawable.span, label = "Span")
        FilterItem(iconId = R.drawable.folder, label = "Pasta pessoal 1")
        FilterItem(iconId = R.drawable.folder, label = "Pasta pessoal 2")
    }
}

@Composable
fun FilterItem(iconId: Int, label: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
        .clickable { /* TODO: Implement filter action */ }) {

        Icon(
            painter = painterResource(id = iconId),
            contentDescription = label,
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(text = label, fontSize = 18.sp, color = Color.Black)
    }
}
