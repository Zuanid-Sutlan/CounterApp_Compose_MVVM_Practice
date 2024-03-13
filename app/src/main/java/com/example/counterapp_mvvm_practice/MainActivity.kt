package com.example.counterapp_mvvm_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.counterapp_mvvm_practice.ui.theme.CounterApp_MVVM_PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterApp_MVVM_PracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Row {
                        Text(text = "After rotating the phone screen. The UI elements" +
                                " reload and lose our previous data if we want to avoid this." +
                                " The MVVM can solve this. In this app we learn MVVM with practice.",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            textAlign = TextAlign.Center)
                    }

                    val counterViewModel: CounterViewModel = viewModel()
                    CounterApp(viewModel = counterViewModel)
                }
            }
        }
    }
}

@Composable
fun CounterApp(viewModel: CounterViewModel) {
    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Display the counter value
            // Use the value property of the MutableState to access the current value
            // of the count variable in CounterViewModel
            CounterValue(viewModel.count.value)
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            ) {
                // Buttons for incrementing and decrementing the counter value
                Button(onClick = { viewModel.increment() }) {
                    // Button text
                    // Increment button
                    Text(text = "Increment")
                }
                Button(onClick = { viewModel.decrement() }) {
                    // Button text
                    // Decrement button
                    Text(text = "Decrement")
                }
            }
        }
    }
}


@Composable
fun CounterValue(count: Int) {
    Text(text = "Count Value: $count")
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    CounterApp_MVVM_PracticeTheme {

    }
}