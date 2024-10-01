package com.esteban.lopez.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.navigation.compose.rememberNavController
import com.esteban.lopez.myapplication.ui.theme.MyApplicationTheme

class InfoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            val name = intent.getStringExtra("name")
            val lastName = intent.getStringExtra("lastName")
            val age = intent.getStringExtra("age")

            MyApplicationTheme {

              Column(
                    modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                  horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                    verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
              ) {
                  Text("Nombre: $name")

                  Text("Apellido: $lastName")

                  Text("Edad: $age")
              }

            }
        }
    }
}