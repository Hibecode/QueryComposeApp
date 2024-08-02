package com.ibukun.query.data.repository

import com.ibukun.query.data.source.RemoteDataSource
import javax.inject.Inject

class GitHubRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) : GitHubRepository {
    override suspend fun searchUsers(query: String) = remoteDataSource.searchUsers(query)
    override suspend fun getUser(username: String) = remoteDataSource.getUser(username)
    override suspend fun getFollowers(username: String) = remoteDataSource.getFollowers(username)
    override suspend fun getFollowing(username: String) = remoteDataSource.getFollowing(username)
    override suspend fun getRepos(username: String) = remoteDataSource.getRepos(username)
}
