package com.example.kmpday1.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.kmpday1.ArticleViewModel
import org.koin.android.ext.android.inject


class MainActivity : ComponentActivity() {
    private val viewModel: ArticleViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val uiState by viewModel.uiState.collectAsState()

                    LaunchedEffect(Unit) {
                        viewModel.loadArticles()
                    }

                    ArticleScreen(
                        uiState = uiState,
                    )
                }
            }
        }
    }
}