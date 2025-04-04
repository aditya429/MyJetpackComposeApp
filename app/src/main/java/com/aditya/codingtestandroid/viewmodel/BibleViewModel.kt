package com.aditya.codingtestandroid.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aditya.codingtestandroid.model.ApiService
import com.aditya.codingtestandroid.model.Verse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BibleViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {


    var verses by mutableStateOf<List<Verse>>(emptyList())
    var isLoading by mutableStateOf(true)
    var errorMessage by mutableStateOf("")

    init {

        fetchVerse()
    }


    fun fetchVerse() {

        viewModelScope.launch(Dispatchers.Default) {
            try {
                isLoading = true
                verses = apiService.getDqta().verses

            } catch (e: Exception) {
                errorMessage = e.message ?: "Failed to load"
            } finally {
                isLoading = false
            }
        }


    }


    fun deletePost(verse : Verse) {
        verses = verses.filterNot { it.book_id == verse.book_id }
    }

}
