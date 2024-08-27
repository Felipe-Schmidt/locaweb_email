package com.example.locawebemail.screens


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.locawebemail.R
import com.example.locawebemail.ui.theme.LocaWebEmailTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CriarConta(navController: NavController) {

    var texto by remember { mutableStateOf("") }
    var texto2 by remember { mutableStateOf("") }
    var dia by remember { mutableStateOf("") }
    var mes by remember { mutableStateOf("") }
    var ano by remember { mutableStateOf("") }
    var novoEndereco by remember { mutableStateOf("") }



    Box(
        modifier = Modifier
            .background(
                Brush.linearGradient(
                    0f to Color(0xff182430),
                    1f to Color(0xff253746).copy(alpha = 0.85f),
                    start = Offset(180f, 0f),
                    end = Offset(180f, 735f)
                )
            )
    )
    {
        Column(
            modifier = Modifier
        )
        {


            //--header
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxWidth()

            )
            {
                Spacer(modifier = Modifier.height(33.dp))
                Image(
                    painter = painterResource(id = R.drawable.logo_small),
                    contentDescription = "Logotipo LocaWeb",
                    modifier = Modifier
                        .requiredWidth(width = 170.dp)
                        .requiredHeight(height = 35.dp)
                )
                Spacer(modifier = Modifier.height(77.dp))
                Text(
                    text = "Crie uma conta de e-mail LocaWeb",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif
                )
                Spacer(modifier = Modifier.height(53.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxWidth()
                        .padding(horizontal = 33.dp)

                ) {

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 17.dp),

                        value = texto,
                        onValueChange = { letra ->
                            texto = letra
                        },

                        label = {
                            Text(text = "Nome")
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(KeyboardCapitalization.Words),
                        shape = RoundedCornerShape(8.dp),

                        )

                    TextField(
                        value = texto2,
                        modifier = Modifier.fillMaxWidth(),
                        onValueChange = { letra ->
                            texto2 = letra
                        },
                        label = {
                            Text(text = "Sobrenome")
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
                        shape = RoundedCornerShape(8.dp)


                    )
                }


            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 17.dp, start = 33.dp, end = 33.dp)
            )

            {
                Text(
                    text = "Data de Nascimento",
                    fontSize = 15.sp,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(9.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    TextField(
                        value = dia,
                        onValueChange = { letra ->
                            dia = letra
                        },
                        singleLine = true,
                        placeholder = { Text(text = "Dia") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .width(93.dp)
                            .weight(1f),
                        shape = RoundedCornerShape(8.dp)

                    )

                    TextField(
                        value = mes,
                        onValueChange = { letra ->
                            mes = letra
                        },
                        singleLine = true,
                        placeholder = { Text(text = "Mês") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .width(93.dp)
                            .weight(1f),
                        shape = RoundedCornerShape(8.dp)


                    )
                    TextField(
                        value = ano,
                        onValueChange = { letra ->
                            ano = letra
                        },
                        singleLine = true,
                        placeholder = { Text(text = "Ano") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .width(93.dp)
                            .weight(1f),
                        shape = RoundedCornerShape(8.dp)


                    )
                }

                Spacer(modifier = Modifier.height(50.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextField(
                        value = novoEndereco,
                        onValueChange = { novoEndereco = it },
                        placeholder = { Text(text = "Seu novo endereço") },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        shape = RoundedCornerShape(8.dp),


                        )

                    Text(
                        text = "@locaweb.com.br",
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(77.dp))
                Button(
                    onClick = {
                        navController.navigate("CaixaDeEntrada")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEB3850)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "AVANÇAR",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }

}




