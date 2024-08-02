package com.ibukun.query.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.ibukun.query.presentation.viewmodels.UserProfileViewModel

@Composable
fun UserProfileScreen(viewModel: UserProfileViewModel, username: String, onFollowerClick: (String) -> Unit, onFollowingClick: (String) -> Unit, onRepoClick: (String) -> Unit) {
    val userProfile by viewModel.userProfile.observeAsState()

    LaunchedEffect(username) {
        viewModel.getUser(username)
    }

    userProfile?.let { profile ->
        Column {
            Text("Name: ${profile.name}")
            Text("Bio: ${profile.bio ?: "No bio available"}")
            Text("Followers: ${profile.followers}", Modifier.clickable { onFollowerClick(username) })
            Text("Following: ${profile.following}", Modifier.clickable { onFollowingClick(username) })
            Text("Repos: ${profile.public_repos}", Modifier.clickable { onRepoClick(username) })
        }
    } ?: run {
        Text("Loading...")
    }
}
