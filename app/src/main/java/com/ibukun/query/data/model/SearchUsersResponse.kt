package com.ibukun.query.data.model

data class SearchUsersResponse( val total_count: Int,
                                val incomplete_results: Boolean,
                                val items: List<User>)
