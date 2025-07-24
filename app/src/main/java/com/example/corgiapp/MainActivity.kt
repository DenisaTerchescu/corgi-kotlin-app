package com.example.corgiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.Card
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.corgiapp.ui.theme.CorgiAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
                        Image(
                            painter = painterResource(R.drawable.wallpaper),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                        CorgiTile(
                            no = 1,
                            title = "First day",
                            body = "Body",
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }


            }
        }
    }
}

@Composable
fun CorgiTile(no: Int, title: String, body: String, modifier: Modifier = Modifier) {
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
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                text = "Day $no",
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
                    painter = painterResource(R.drawable.corgi_1),
                    contentDescription = "Corgi day %no",
                    modifier = Modifier
                        .padding(8.dp)
//                        .fillMaxWidth()

                        .size(200.dp)
                )
            }


            Text(
                text = "Don't forget to have an absolutely corgi-tastic day!!",
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFFFA5000),
                textAlign = TextAlign.Center
            )
        }

    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CorgiAppTheme {
        CorgiTile(
            no = 1,
            title = "First day",
            body = "Lorem ipsum",
        )
    }
}