package com.esteban.lopez.myapplication

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController){
    val context = LocalContext.current
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ElevatedButton(modifier = Modifier.padding(innerPadding), onClick = {
                Toast.makeText(context, "Hola Mundo!", Toast.LENGTH_SHORT).show()}) {
                Text("Show Toast")
            }
            ElevatedButton(modifier = Modifier.padding(innerPadding), onClick = {
                navController.navigate("login")
            }) {
                Text("Open Login")
            }
        }
    }
}