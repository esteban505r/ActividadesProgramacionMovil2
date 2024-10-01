package com.esteban.lopez.myapplication

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onLoginClick: (String, String) -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var webPagetoSearch by remember { mutableStateOf("") }
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Column {
            Text(
                text = "Nombre del Programa: Ingeniería de Software",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Nombre de la Asignatura: Desarrollo de Aplicaciones Móviles",
                fontSize = 18.sp
            )

            Text(
                text = "Nombre del Integrante: Hugo Esteban Ruano Lopez",
                fontSize = 18.sp
            )

            Text(
                text = "Semestre y Año: 2024,  Septimo Semestre",
                fontSize = 18.sp
            )

            Text(
                text = "Docente: Robert Osorio",
                fontSize = 18.sp
            )
        }

        Image(
            painter = painterResource(id = R.drawable.umb_logo),
            contentDescription = "UMB Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(120.dp)
                .padding(16.dp)
        )

        OutlinedTextField(value = webPagetoSearch, onValueChange = {
            webPagetoSearch = it
        }, label = { Text("Buscar pagina") },
            placeholder = { Text("Ingrese la pagina a buscar") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    keyboardController?.hide()
                    val intent = Intent(ACTION_VIEW, Uri.parse(webPagetoSearch))
                    context.startActivity(intent)
                }
            ),
            trailingIcon = {
                Image(
                    painter = painterResource( R.drawable.search),
                    contentDescription = "Search",
                    modifier = Modifier
                        .clickable {
                            val intent = Intent(ACTION_VIEW, Uri.parse(webPagetoSearch))
                            context.startActivity(intent)
                        }
                        .size(24.dp)
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Abrir pagina de la UMB",
            style = MaterialTheme.typography.titleLarge.copy(
                color = MaterialTheme.colorScheme.primary,
                textDecoration = TextDecoration.Underline
            ),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .clickable {
                    val intent = Intent(ACTION_VIEW, Uri.parse("https://www.umb.edu.co/"))
                    context.startActivity(intent)
                }
        )


        Button(
            onClick = {
                context.startActivity(Intent(context, RegisterActivity::class.java))
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrarse")
        }
    }

}