package com.example.corgiapp.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.corgiapp.R

@Composable
fun CorgiDayCarousel(modifier: Modifier = Modifier) {
    val days = listOf(
        R.drawable.corgi_1 to "Boop the snoot!",
        R.drawable.corgi_2 to "Boop the snoot!",
        R.drawable.corgi_3 to "Boop the snoot!",
        R.drawable.corgi_4 to "Boop the snoot!",
        R.drawable.corgi_1 to "Boop the snoot!",
    )

    val pagerState = rememberPagerState(pageCount = { days.size })

    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 32.dp),
        pageSpacing = 16.dp,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp)
    ) { page ->
        val (imageId, body) = days[page]

        CorgiTile(
            corgiPicId = imageId,
            dayNo = page + 1,
            description = body,
            modifier = modifier
        )
    }
}
