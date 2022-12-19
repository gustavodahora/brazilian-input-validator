package dev.gustavodahora.napp.view.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dev.gustavodahora.napp.ui.theme.NappTheme
import dev.gustavodahora.napp.view.composable.MainScreen
import dev.gustavodahora.napp.view.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NappTheme {
                MainScreen(mainViewModel)
            }
        }
    }
}
