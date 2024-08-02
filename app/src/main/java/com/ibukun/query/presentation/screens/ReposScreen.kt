package com.ibukun.query.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.ibukun.query.presentation.viewmodels.ReposViewModel

@Composable
fun ReposScreen(viewModel: ReposViewModel, username: String) {
    val repos by viewModel.repos.observeAsState(emptyList())

    LaunchedEffect(username) {
        viewModel.getRepos(username)
    }

    LazyColumn {
        items(repos) { repo ->
            Text(repo.name, Modifier.clickable { /* handle click */ })
        }
    }
}
