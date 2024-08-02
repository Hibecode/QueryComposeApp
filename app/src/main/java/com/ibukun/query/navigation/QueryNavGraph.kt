package com.ibukun.query.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ibukun.query.presentation.screens.FollowersScreen
import com.ibukun.query.presentation.screens.FollowingScreen
import com.ibukun.query.presentation.screens.ReposScreen
import com.ibukun.query.presentation.screens.SearchScreen
import com.ibukun.query.presentation.screens.UserProfileScreen

@Composable
fun QueryNavGraph(startDestination: String = "search") {
    val navController = rememberNavController()

    NavHost(navController, startDestination = startDestination) {
        composable("search") {
            SearchScreen(
                viewModel = hiltViewModel(),
                onUserClick = { username ->
                    navController.navigate("profile/$username")
                }
            )
        }
        composable("profile/{username}") { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: return@composable
            UserProfileScreen(
                viewModel = hiltViewModel(),
                username = username,
                onFollowerClick = { navController.navigate("followers/$username") },
                onFollowingClick = { navController.navigate("following/$username") },
                onRepoClick = { navController.navigate("repos/$username") }
            )
        }
        composable("followers/{username}") { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: return@composable
            FollowersScreen(
                viewModel = hiltViewModel(),
                username = username,
                onUserClick = { navController.navigate("profile/$it") }
            )
        }
        composable("following/{username}") { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: return@composable
            FollowingScreen(
                viewModel = hiltViewModel(),
                username = username,
                onUserClick = { navController.navigate("profile/$it") }
            )
        }
        composable("repos/{username}") { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: return@composable
            ReposScreen(viewModel = hiltViewModel(), username = username)
        }
    }
}
