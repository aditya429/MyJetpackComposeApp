package com.aditya.codingtestandroid.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aditya.codingtestandroid.model.Verse

@Composable
fun VerseItem(verse: Verse){
    
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp), elevation = CardDefaults.cardElevation(8.dp)) {
        
        Column {
            Text(text = "${verse.book_name} , ${verse.chapter}" )
        }
        
    }
    
}