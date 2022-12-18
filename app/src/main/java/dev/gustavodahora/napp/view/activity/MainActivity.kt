package dev.gustavodahora.napp.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import dev.gustavodahora.napp.ui.theme.NappTheme
import dev.gustavodahora.napp.view.composable.MainScreen
import dev.gustavodahora.napp.view.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupObservers()

        setContent {
            NappTheme {
                MainScreen(mainViewModel)
            }
        }
    }

    private fun setupObservers() {
        mainViewModel.toastStatus.observe(this) {
            showToast()
        }
    }

    private fun showToast() {
        Toast.makeText(applicationContext, "WOW!", Toast.LENGTH_SHORT).show()
    }
}
