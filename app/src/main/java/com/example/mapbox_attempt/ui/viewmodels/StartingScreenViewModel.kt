package com.example.mapbox_attempt.ui.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mapbox_attempt.repositories.LibraryData
import com.example.mapbox_attempt.repositories.LibraryDataRepository

class StartingScreenViewModel(libraryDataRepository: LibraryDataRepository) : ViewModel() {

    private val _uiState = mutableStateOf(StartScreenState())
    val uiState: State<StartScreenState> = _uiState

    // Function to handle menu selection
    fun selectMenuItem(item: String) {
        _uiState.value = _uiState.value.copy(
            selectedItem = item
        )
    }

    /* TODO: Need a function that fetches the library data as soon as the view model is ready. Needs
        to do this concurrently so not as to block the UI from running.
        Get my fuel app project from work laptop to reference when confused.
        Need to implement koin!!!!!!!!!!!
     */

    fun getSelectedMenuItem() : String {
        return uiState.value.selectedItem
    }
}

data class StartScreenState(
    val menuItems: List<String> = listOf("Play", "Settings", "About", "Exit"),
    val selectedItem: String = "",
    val usersLibrary: LibraryData? = null
)