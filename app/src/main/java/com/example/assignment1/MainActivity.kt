package com.example.assignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


import com.example.assignment1.ui.theme.Assignment1Theme

data class Dimension(
    val name: String,
    val constraint: String,
    val implication: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment1Theme {
                MobilityLensScreen()
            }
        }
    }
}

@Composable
fun MobilityLensScreen() {

    val dimensions = listOf(
        Dimension(
            name = "Input and interaction",
            constraint = "Mobile users interact through touch, gestures, voice, and small on-screen controls",
            implication = "Use large touch targets, simple navigation, clear feedback, and generally, stay away from precise inputs."
        ),
        Dimension(
            name = "Screen size, orientation, and density",
            constraint = "Mobile devices come in varying different sizes of screen sizes, pixel density and portrait dimensions.",
            implication = "Create responsive layouts that can adapt to varying sizes and keeps everything readable and usable."
        ),
        Dimension(
            name = "Lifecycle and resource constraints",
            constraint = "Mobile apps have limited battery, memory and processing power. They can also be paused stopped and rebooted at any time.",
            implication = "Make sure to preserve important states, avoid unnecessary imports and background work."
        ),
        Dimension(
            name = "Context awareness",
            constraint = "A mobile device can detect information such as location, movement, time, connectivity, and nearby devices.",
            implication = "Only use this information when absolutely necessary, and ask for permission first."
        ),
        Dimension(
            name = "Usage patterns",
            constraint = "Mobile apps are often used in short interupted spurts, accompanied by different environments.",
            implication = "Make common tasks quick, save progress automatically and often, and allow users to resume where they stopped."
        ),
        Dimension(
            name = "Security and privacy expectations",
            constraint = "Mobile devices store personal information and may be lost, shared, or potentially through insecure networks.",
            implication = "Collect only necessary data, protect information, and explain permission requests."
        )
    )
    var currentIndex by remember { // dimension
        mutableIntStateOf(0)
    }
    var appName by remember {
        mutableStateOf("")
    }

    var hasError by remember {
        mutableStateOf(false)
    }
    var inputMessage by remember {
        mutableStateOf("")
    }
    var showHeader by remember {
        mutableStateOf(true)
    }

    var currentDimension = dimensions[currentIndex]

    Scaffold(
        modifier = Modifier.fillMaxSize()

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            // HEADER-----------------------
            if (showHeader) {
                Header(text = "Mobility Lens")

                Body(
                    text = "Explore six ways mobile applications differ from " +
                            "other applications and consider their design implications."
                )
            }
            // END HEADER-----------------------

            Header(text = currentDimension.name)
            Body(text = "Constraint: " + currentDimension.constraint)
            Body(text = "Implication: " + currentDimension.implication)

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = {
                        currentIndex--
                    },
                    enabled = currentIndex > 0
                ) {
                    Text("Previous")
                }
                Button(
                    onClick = {
                        currentIndex++
                        if(showHeader){
                            showHeader = false
                        }
                    },
                    enabled = currentIndex < 5
                ) {
                    Text("Next")
                }
            }

            OutlinedTextField(
                value = appName,
                onValueChange =  {
                    appName = it
                    hasError = false
                },
                isError = hasError,
                supportingText = {
                    if(hasError) {
                        Text("Field cannot be empty.")
                    }
                },
                maxLines = 20

            )

            Button(
                onClick = {
                    if(appName.isBlank()) {
                        hasError = true
                        inputMessage = ""
                    }
                    else {
                       hasError = false
                       inputMessage = "$appName in dimension: ${currentDimension.name}"
                    }
                }
            ) {
                Body("Submit Input")
            }

            if(inputMessage.isNotEmpty()) {
                if (inputMessage.length > 1000) {
                    Body("$inputMessage (sidenote: you have a lot to say huh)")
                }
                else {
                    Body(inputMessage)
                }

            }

        }
    }
}

// Reusable components

@Composable
fun Header(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 35.sp,
        modifier = modifier
    )
}
@Composable
fun Body(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        modifier = modifier
    )
}

@Composable
@Preview
fun MobilityScreenPreview() {
    Assignment1Theme {
        MobilityLensScreen()
    }
}
