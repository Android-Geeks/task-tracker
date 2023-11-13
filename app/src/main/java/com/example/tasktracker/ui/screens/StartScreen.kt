package com.example.tasktracker.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tasktracker.R

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onLoginClick: () -> Unit,
    onCreateAccountClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        Arrangement.spacedBy(36.dp)
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                painterResource(R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "Back"
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            Arrangement.spacedBy(26.dp), Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.welcome_to_uptodo),
                modifier = Modifier
                    .alpha(.87f),
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = stringResource(R.string.please_login),
                modifier = Modifier
                    .alpha(.67f)
                    .padding(horizontal = 20.dp),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = onLoginClick,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(text = stringResource(R.string.login))
            }
            OutlinedButton(
                onClick = onCreateAccountClick,
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(4.dp, MaterialTheme.colorScheme.primary),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.onBackground)
            ) {
                Text(text = stringResource(R.string.create_account))
            }
            Spacer(modifier = Modifier.height(24.dp))
        }

    }

}

@Preview(showBackground = true)
@Composable
fun Pre() {
    StartScreen(Modifier, {}, {}, {})
}