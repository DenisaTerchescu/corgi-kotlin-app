package com.example.corgiapp.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.corgiapp.R
import com.example.corgiapp.ui.theme.CorgiAppTheme

@Composable
fun CorgiDayCarousel(modifier: Modifier = Modifier) {
    val days = listOf(
        R.drawable.corgi_1 to "Feel paws-itive today!",
        R.drawable.corgi_2 to "Have a corgi-tasctic day!",
        R.drawable.corgi_3 to "A corgi a day keeps the blues away",
        R.drawable.corgi_4 to "Let's paws for a moment!",
        R.drawable.corgi_5 to "Beware of the cuteness overload!",
        R.drawable.corgi_6 to "This day is gonna be un-for-gettable!!",
        R.drawable.corgi_7 to "Fur the love fo corgi!",
        R.drawable.corgi_8 to "Let's unleash the fun! ",
        R.drawable.corgi_9 to "Boop the snoot!",
        R.drawable.corgi_10 to "Corgi-dence is key!",
        R.drawable.corgi_11 to "May the corgi be with you.",
        R.drawable.corgi_12 to "Corgi-tulate me, I’m adorable!",
        R.drawable.corgi_13 to "It’s a corgi-tastic day to be happy!",
        R.drawable.corgi_14 to "Corgi-nize your life with a puppy hug!",
        R.drawable.corgi_15 to "Corgi-ously fluffy and paws-itively lovable!",
    )

    val pagerState = rememberPagerState(pageCount = { 2* days.size })

    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 32.dp),
        pageSpacing = 16.dp,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp)
    ) { page ->
        val (imageId, body) = days[page%15]

        CorgiTile(
            corgiPicId = imageId,
            dayNo = page + 1,
            description = body,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CorgiCarouselPreview() {
    CorgiAppTheme {
        CorgiDayCarousel()
    }
}
