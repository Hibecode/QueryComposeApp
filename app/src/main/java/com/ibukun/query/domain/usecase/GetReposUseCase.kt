package com.ibukun.query.domain.usecase

import com.ibukun.query.data.repository.GitHubRepository
import javax.inject.Inject

class GetReposUseCase @Inject constructor(private val repository: GitHubRepository) {
    suspend operator fun invoke(username: String) = repository.getRepos(username)
}
