package com.example.jualan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jualan.ui.screen.BasicInfoScreen
import com.example.jualan.ui.screen.HubungiKamiScreen
import com.example.jualan.ui.theme.JualanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JualanTheme {
                // Surface bertindak sebagai kanvas dasar
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Membuat 'pemandu jalan' navigasi
                    val navController = rememberNavController()

                    // Mengatur rute dan halaman pertama yang muncul (basic_info)
                    NavHost(navController = navController, startDestination = "basic_info") {

                        // Mendaftarkan halaman BasicInfoScreen
                        composable(route = "basic_info") {
                            BasicInfoScreen(
                                onNavigateToContact = { navController.navigate(route = "form_screen") }
                            )
                        }

                        // Mendaftarkan halaman HubungiKamiScreen
                        composable(route = "form_screen") {
                            HubungiKamiScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}