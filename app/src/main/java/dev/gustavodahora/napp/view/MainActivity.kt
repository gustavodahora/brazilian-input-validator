package dev.gustavodahora.napp.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import dev.gustavodahora.napp.ui.theme.NappTheme
import dev.gustavodahora.napp.view.composable.MainScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NappTheme {
                MainScreen()
            }
        }
    }
}
