package com.example.tasktracker.screen.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tasktracker.R
import com.example.tasktracker.ui.theme.TaskTrackerTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    onSkipClick: () -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { 3 })
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
    ) {
        Text(
            text = stringResource(R.string.skip),
            style = MaterialTheme.typography.bodySmall,
            color = Color.LightGray,
            modifier = Modifier.clickable {
                onSkipClick()
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(11f),
            verticalAlignment = Alignment.Top,
        ) { position ->
            PagerScreen(
                onBoardingPage = pages[position],
            )
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier.weight(1f)
        )
        FinishButton(
            pagerState = pagerState,
            onClick = onSkipClick,
            modifier = Modifier.weight(1f),
        )
    }
}


@Composable
fun PagerScreen(
    onBoardingPage: OnBoardingPage,
) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = onBoardingPage.image),
                contentDescription = "OnBoarding Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Spacer(modifier = Modifier.height(70.dp))
            Text(
                text = stringResource(id = onBoardingPage.title),
                style = MaterialTheme.typography.displayMedium,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = stringResource(id = onBoardingPage.description),
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerIndicator(
    pagerState: PagerState,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) Color.LightGray else Color.DarkGray
            Box(
                modifier = Modifier
                    .width(36.dp)
                    .height(6.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(color)
                    .size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 2
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(text = "Get Started")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun OnBoardingScreenPreview() {
    TaskTrackerTheme {
        OnBoardingScreen(
            onSkipClick = {}
        )
    }
}