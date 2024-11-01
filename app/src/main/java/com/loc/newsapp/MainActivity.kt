package com.loc.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.loc.newsapp.presentation.onboarding.OnboardingScreen
import com.loc.newsapp.presentation.onboarding.OnboardingViewModel
import com.loc.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
        setContent {
            NewsAppTheme {
                Box(
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.background)
                ) {
                    val viewModel: OnboardingViewModel = hiltViewModel()
                    OnboardingScreen(
                        event = viewModel::onEvent
                    )
                }
            }
        }
    }
}
