package com.ibukun.query.domain.usecase

import com.ibukun.query.data.model.SearchUsersResponse
import com.ibukun.query.data.repository.GitHubRepository

import javax.inject.Inject

class SearchUsersUseCase @Inject constructor(private val repository: GitHubRepository) {
    suspend operator fun invoke(query: String): SearchUsersResponse {
        return repository.searchUsers(query)
    }
}
