package com.aditya.codingtestandroid.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.aditya.codingtestandroid.viewmodel.BibleViewModel

@Composable
fun BibleVerseList(viewModel: BibleViewModel = hiltViewModel()){
    val verses = viewModel.verses
    val isLoading = viewModel.isLoading
    val error = viewModel.errorMessage

    when {

        isLoading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        error.isNotEmpty() -> {
            Text("Error : $error", color = Color.Red)
        }
         else -> {
             LazyColumn {

                 items(verses){
                         verses -> VerseItem(verses)
                 }

             }
         }
    }
}