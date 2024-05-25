package com.example.quoteapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quoteapp.model.quote

@Composable
fun QuoteList(data:Array<quote>,onClick:(quote:quote)->Unit)
{
  LazyColumn(content = {
      items(data){
          QuoteListItem(quote = it,onClick)
      }
  })
}