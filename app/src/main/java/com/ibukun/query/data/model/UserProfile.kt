package com.ibukun.query.data.model

data class UserProfile(
    val login: String,
    val id: Int,
    val avatar_url: String,
    val name: String,
    val bio: String?,
    val followers: Int,
    val following: Int,
    val public_repos: Int,
)