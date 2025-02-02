package com.example.mapbox_attempt.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun StartingScreenCard(titleText: String, descriptionText: String, buttonText: String, onButtonClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = titleText,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black
            )
            Text(
                text = descriptionText,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                color = Color.Gray
            )
            Button(
                onClick = { onButtonClick(buttonText) },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.DarkGray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = buttonText,
                    fontSize = 18.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StartingScreenCard(
        "Sample Text",
        "This is a descriptive text",
        "Button Text",
        onButtonClick = {  }
    )
}
