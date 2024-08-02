package com.ibukun.query.domain.usecase

import com.ibukun.query.data.repository.GitHubRepository
import javax.inject.Inject

class GetFollowersUseCase @Inject constructor(private val repository: GitHubRepository) {
    suspend operator fun invoke(username: String) = repository.getFollowers(username)
}
