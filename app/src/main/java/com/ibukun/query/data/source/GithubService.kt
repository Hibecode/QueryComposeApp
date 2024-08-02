package com.ibukun.query.data.source

import com.ibukun.query.data.model.Repo
import com.ibukun.query.data.model.SearchUsersResponse
import com.ibukun.query.data.model.User
import com.ibukun.query.data.model.UserProfile
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApiService {
    @Headers("Authorization: Bearer github_pat_hbhb")
    @GET("search/users")
    suspend fun searchUsers(@Query("q") query: String): SearchUsersResponse

    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): UserProfile

    @GET("users/{username}/followers")
    suspend fun getFollowers(@Path("username") username: String): List<User>

    @GET("users/{username}/following")
    suspend fun getFollowing(@Path("username") username: String): List<User>

    @GET("users/{username}/repos")
    suspend fun getRepos(@Path("username") username: String): List<Repo>
}
