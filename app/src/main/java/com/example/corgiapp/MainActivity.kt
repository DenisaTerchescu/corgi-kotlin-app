package com.example.corgiapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CardColors
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.corgiapp.ui.theme.CorgiAppTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val currentDay = LocalDate.now().dayOfMonth

        setContent {
            CorgiAppTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_paw),
                                        contentDescription = stringResource(R.string.ic_description_text),
//                                        tint = Color(0xFFFFA726),
                                        modifier = Modifier
                                            .align(Alignment.CenterVertically)
                                            .size(24.dp)
                                    )
                                    Text(
                                        text = "30 Days of Corgi",
                                        modifier = Modifier
                                            .align(Alignment.CenterVertically)
                                            .padding(horizontal = 8.dp)
                                    )

                                    Icon(
                                        painter = painterResource(R.drawable.ic_paw),
                                        contentDescription = stringResource(R.string.ic_description_text),
//                                        tint = Color(0xFFFFA726),
                                        modifier = Modifier
                                            .align(Alignment.CenterVertically)
                                            .size(24.dp)
                                    )
                                }
                            },
                            colors = TopAppBarColors(
                                containerColor = Color(0xFFFFA726),
                                scrolledContainerColor = Color(0xFFFFA726),
                                navigationIconContentColor = Color(0xFFFFA726),
                                titleContentColor = Color.Black,
                                actionIconContentColor = Color(0xFFFFA726),
                            ),

                            )
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // the app wallpaper
                        Image(
                            painter = painterResource(R.drawable.wallpaper),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )


                        // the day tile/card
                        CorgiTile(
                            corgiPicId = R.drawable.corgi_1,
                            dayNo = 1,
                            description = "Don't forget to have an absolutely corgi-tastic day!!",
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(innerPadding)
                        )
                    }
                }


            }
        }
    }
}

@Composable
fun CorgiTile(@DrawableRes corgiPicId: Int, dayNo: Int, description: String, modifier: Modifier = Modifier) {
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
                onClick = {},
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
        }

    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CorgiAppTheme {
        CorgiTile(
            dayNo = 1,
            description = "Lorem ipsum",
            corgiPicId = R.drawable.corgi_1
        )
    }
}