package com.example.quoteapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quoteapp.R
import com.example.quoteapp.model.quote

@Composable
fun QuoteListScreen(data:Array<quote>,onClick:(quote:quote)->Unit){
    Column {
        Text(text = "Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp,24.dp) .fillMaxWidth(),
            style = MaterialTheme.typography.bodyMedium,
            fontFamily = FontFamily(Font(R.font.refractor))
        )
        QuoteList(data = data ,onClick)

    }
}