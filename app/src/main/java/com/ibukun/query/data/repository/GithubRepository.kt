package com.ibukun.query.data.repository

import com.ibukun.query.data.model.Repo
import com.ibukun.query.data.model.SearchUsersResponse
import com.ibukun.query.data.model.User
import com.ibukun.query.data.model.UserProfile

interface GitHubRepository {
    suspend fun searchUsers(query: String): SearchUsersResponse
    suspend fun getUser(username: String): UserProfile
    suspend fun getFollowers(username: String): List<User>
    suspend fun getFollowing(username: String): List<User>
    suspend fun getRepos(username: String): List<Repo>
}
