package com.example.mapbox_attempt.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        // Display the list of menu items
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
            Text("Selected: $selectedItem", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
fun MenuItem(item: String, onItemClick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .width(100.dp)
            .clickable{ onItemClick(item) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = item,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    StartingScreen()
}