package com.venkatesh.foodiefriends.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.venkatesh.foodiefriends.LoginScreen
import com.venkatesh.foodiefriends.data.home.HomeViewModel
import com.venkatesh.foodiefriends.navigation.FoodiesAppRouter
import com.venkatesh.foodiefriends.navigation.Screen
import com.venkatesh.foodiefriends.screens.HomeScreen
import com.venkatesh.foodiefriends.screens.SignUpScreen
import com.venkatesh.foodiefriends.screens.TermsAndConditionsScreen


@Composable
fun FoodiesApp(homeViewModel: HomeViewModel = viewModel()) {

    homeViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        if (homeViewModel.isUserLoggedIn.value == true) {
            FoodiesAppRouter.navigateTo(Screen.HomeScreen)
        }

        Crossfade(targetState = FoodiesAppRouter.currentScreen) { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }

                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }

                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.HomeScreen -> {
                    HomeScreen()
                }
            }
        }

    }
}