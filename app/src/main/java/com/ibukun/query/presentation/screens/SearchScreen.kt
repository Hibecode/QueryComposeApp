package com.ibukun.query.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ibukun.query.presentation.viewmodels.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(viewModel: SearchViewModel, onUserClick: (String) -> Unit) {
    var query by remember { mutableStateOf("") }
    val users by viewModel.users.observeAsState(emptyList())

    Scaffold(topBar = { TopAppBar(title = {  }) }) {
            innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(12.dp)) {
            TextField(modifier = Modifier.fillMaxWidth(),
                value = query,
                onValueChange = { query = it },
                label = { Text("Search Users") }
            )
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp), onClick = { viewModel.searchUsers(query) }) {
                Text("Search")
            }
            LazyColumn {
                items(users) { user ->
                    Text(user.login, Modifier.clickable { onUserClick(user.login) })
                }
            }
        }

        }

}
