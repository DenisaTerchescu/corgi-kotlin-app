package com.example.corgiapp.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CardColors
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CorgiTile(@DrawableRes corgiPicId: Int, dayNo: Int, description: String, modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(false) }
    ElevatedCard(
        modifier = modifier
            .padding(horizontal = 24.dp)
            .padding(vertical = 24.dp)
            .fillMaxWidth(),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color.White,
            disabledContentColor = Color.Black
        )
    ) {

        Column(
            modifier = Modifier.padding(vertical = 28.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                text = "Day $dayNo",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFFFA726))
            ) {
                Image(
                    painter = painterResource(corgiPicId),
                    contentDescription = "Corgi day %no",
                    modifier = Modifier
                        .padding(8.dp)
//                        .fillMaxWidth()

                        .size(200.dp)
                )
            }


            Text(
                text = description,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFFFA5000),
                textAlign = TextAlign.Center
            )

            Button(
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth(0.5f),
                onClick = {showDialog = true},
                colors = ButtonColors(
                    containerColor = Color(0xFFFFA726),
                    contentColor = Color.White,
                    disabledContainerColor = Color(0xFFFFA726),
                    disabledContentColor = Color.White
                )
            ) {
                Text(
                    text = "Boop",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )
            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text(text = "Boop!") },
                    text = { Text(text = "Hey, you just booped me!") },
                    confirmButton = {
                        TextButton(onClick = { showDialog = false }) {
                            Text("OK")
                        }
                    }
                )
            }
        }

    }


}