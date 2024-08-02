package com.ibukun.query.data.model

data class Repo(
    val id: Int,
    val name: String,
    val description: String?,
    val html_url: String
)