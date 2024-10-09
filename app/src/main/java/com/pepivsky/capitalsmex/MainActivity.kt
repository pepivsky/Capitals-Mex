package com.pepivsky.capitalsmex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pepivsky.capitalsmex.ui.CardFace
import com.pepivsky.capitalsmex.ui.FlipCard
import com.pepivsky.capitalsmex.ui.RotationAxis
import com.pepivsky.capitalsmex.ui.theme.CapitalsMexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CapitalsMexTheme {

                MainScreen()

            }
        }
    }
}

//@Preview
@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        var cardFace by remember { mutableStateOf(CardFace.Front) }
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {

            Column {
                FlipCard(
                    cardFace = cardFace,
                    onClick = { cardFace = cardFace.next },
                    modifier = Modifier.size(250.dp)
                    /*.fillMaxWidth(.5f)
                    .aspectRatio(1f)*/
                    ,
                    front = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Red),
                            contentAlignment = Alignment.Center,
                        ) {
                            Text(
                                text = "Front",
                            )
                        }
                    },
                    back = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Blue),
                            contentAlignment = Alignment.Center,
                        ) {
                            Text(
                                text = "Back",
                            )
                        }
                    },
                )

                Button(modifier = Modifier,onClick = { }) {
                    Text(text = "Continuar")
                }
            }


        }

    }
}

/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CapitalsMexTheme {
        Greeting("Android")
    }
}*/

@Preview()
@Composable()
fun MyCard(text: String = "Example") {
    Card(modifier = Modifier.size(250.dp), onClick = { /*TODO*/ }) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = text, textAlign = TextAlign.Center)
        }
    }
}