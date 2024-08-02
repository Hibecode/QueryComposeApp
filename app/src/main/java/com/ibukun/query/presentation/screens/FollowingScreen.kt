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
import com.ibukun.query.presentation.viewmodels.FollowingViewModel

@Composable
fun FollowingScreen(viewModel: FollowingViewModel, username: String, onUserClick: (String) -> Unit) {
    val following by viewModel.following.observeAsState(emptyList())

    LaunchedEffect(username) {
        viewModel.getFollowing(username)
    }

    LazyColumn {
        items(following) { user ->
            Text(user.login, Modifier.clickable { onUserClick(user.login) })
        }
    }
}
