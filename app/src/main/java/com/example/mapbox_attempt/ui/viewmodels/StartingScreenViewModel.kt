package com.example.mapbox_attempt.ui.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class StartingScreenViewModel() : ViewModel() {

    private val _uiState = mutableStateOf(StartScreenState())
    val uiState: State<StartScreenState> = _uiState

    // Function to handle menu selection
    fun selectMenuItem(item: String) {
        _uiState.value = _uiState.value.copy(
            selectedItem = item
        )
    }

    fun getSelectedMenuItem() : String {
        return uiState.value.selectedItem
    }
}

data class StartScreenState(
    val menuItems: List<String> = listOf("Play", "Settings", "About", "Exit"),
    val selectedItem: String = ""
)