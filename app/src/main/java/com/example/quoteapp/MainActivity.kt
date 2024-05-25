package com.example.quoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.quoteapp.screens.QuoteDetail
import com.example.quoteapp.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            Datamanager.loadAsset(applicationContext)
        }
        setContent {
            App()
        }
    }
}


@Composable
fun App(){
   if(Datamanager.IsDataLoaded.value) {
       if(Datamanager.currentPage.value==Pages.LISTING) {
           QuoteListScreen(data = Datamanager.data) {
                Datamanager.switchPages(it)
           }
       }
       else{
           Datamanager.currentQuote?.let { QuoteDetail(quote= it) }
       }
   }
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth(1f)
    ){
        Text(text = "Loading....",
            style = MaterialTheme.typography.headlineLarge)
    }
}

enum class Pages{
    LISTING,
    DETAIL
}