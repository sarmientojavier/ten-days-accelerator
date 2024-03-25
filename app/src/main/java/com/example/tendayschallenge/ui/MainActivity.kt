package com.example.tendayschallenge.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tendayschallenge.ui.theme.TenDaysChallengeTheme

class MainActivity : ComponentActivity() {

    private val viewModel: NasaResourcesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getNasaResourceList()

        setContent {
            val nasaResourceStateFlow = remember { viewModel.nasaResourceList }
            val nasaResourceState = nasaResourceStateFlow.collectAsState()
            TenDaysChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState())
                            .fillMaxHeight()
                    ) {
                        ResponseText(nasaResourceState.value.toString())
                    }
                }
            }
        }
    }
}

@Composable
fun ResponseText(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(16.dp)
    )
}