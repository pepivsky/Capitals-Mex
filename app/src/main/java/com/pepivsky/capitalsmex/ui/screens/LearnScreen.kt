package com.pepivsky.capitalsmex.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.pepivsky.capitalsmex.ui.CardFace
import com.pepivsky.capitalsmex.ui.FlipCard

@Preview
@Composable
fun LearnScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        ConstraintLayout(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {

            val startGuide = createGuidelineFromStart(0.05F)
            val endGuide = createGuidelineFromEnd(0.05F) // usando porcentajes
            val bottomGuide = createGuidelineFromBottom(0.1F)
            val (cardRef, btnNextRef) = createRefs()

            var cardFace by remember { mutableStateOf(CardFace.Front) }


            FlipCard(modifier = Modifier
                .size(250.dp)
                .constrainAs(cardRef) {
                    start.linkTo(startGuide)
                    end.linkTo(endGuide)
                    bottom.linkTo(parent.bottom)
                    top.linkTo(parent.top)
                },
                cardFace = cardFace,
                onClick = { cardFace = cardFace.next },
                //modifier = Modifier.size(250.dp)
                /*.fillMaxWidth(.5f)
                .aspectRatio(1f)*/

                front = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Red),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = "Front", color = Color.White,
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
                            text = "Back", color = Color.White,
                        )
                    }
                },
            )

            Button(modifier = Modifier.constrainAs(btnNextRef) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(bottomGuide)
            }, onClick = { /*TODO*/ }) {
                Text(text = "Next")
            }

        }
    }
}