package com.example.myapplication5.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication5.ViewModels.CustomerViewModel
import com.example.myapplication5.ui.theme.screens.customerScreen.CustomerScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "customer") {
        composable("customer") {
            val viewModel = CustomerViewModel()
            CustomerScreen(viewModel = viewModel)
        }
    }
}
