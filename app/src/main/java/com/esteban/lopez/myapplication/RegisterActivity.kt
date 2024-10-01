package com.esteban.lopez.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.esteban.lopez.myapplication.ui.theme.MyApplicationTheme

class RegisterActivity: ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            var name by remember { mutableStateOf("") }
            var lastName by remember { mutableStateOf("") }
            var age by remember { mutableStateOf("") }

            MyApplicationTheme {

              Column(
                    modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                    verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
              ) {
                  OutlinedTextField(value = name, onValueChange = {
                      name = it
                  }, label = { Text("Nombre") })

                  OutlinedTextField(value = lastName, onValueChange = {
                      lastName = it
                  }, label = { Text("Apellido") })

                  OutlinedTextField(value = age, onValueChange = {
                      age = it
                  }, label = { Text("Edad") })

                  ElevatedButton(onClick = {
                      val intent = Intent(this@RegisterActivity, InfoActivity::class.java)
                      intent.putExtra("name", name)
                      intent.putExtra("lastName", lastName)
                      intent.putExtra("age", age)
                      startActivity(intent)
                  }) {
                      Text("Mostrar info")
                  }

              }
            }
        }
    }
}