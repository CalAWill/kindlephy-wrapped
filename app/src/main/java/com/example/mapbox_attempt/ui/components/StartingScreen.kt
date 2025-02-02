package com.example.mapbox_attempt.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mapbox_attempt.ui.viewmodels.StartingScreenViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun StartingScreen(
    viewModel: StartingScreenViewModel = viewModel()
) {
    val menuItems = viewModel.uiState.value.menuItems
    val selectedItem = viewModel.getSelectedMenuItem()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        // Display the list of menu items
        item{
            Column {
                menuItems.forEachIndexed {index, item ->
                    MenuItem(item = item, onItemClick = {
                        viewModel.selectMenuItem(it)
                    })
                    if (index != menuItems.lastIndex) {
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

                // Display the selected menu item
                if (selectedItem.isNotEmpty()) {
                    Text("Selected: $selectedItem",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun MenuItem(item: String, onItemClick: (String) -> Unit) {
    StartingScreenCard(titleText = "This is a card for the $item button.",
        descriptionText = "Description text",
        buttonText = item,
        onButtonClick = onItemClick
    )
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    StartingScreen()
}