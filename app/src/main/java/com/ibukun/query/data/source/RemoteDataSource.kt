package com.ibukun.query.data.source

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: GitHubApiService) {
    suspend fun searchUsers(query: String) = apiService.searchUsers(query)
    suspend fun getUser(username: String) = apiService.getUser(username)
    suspend fun getFollowers(username: String) = apiService.getFollowers(username)
    suspend fun getFollowing(username: String) = apiService.getFollowing(username)
    suspend fun getRepos(username: String) = apiService.getRepos(username)
}
