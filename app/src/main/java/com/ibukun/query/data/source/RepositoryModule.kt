package com.ibukun.query.data.source

import com.ibukun.query.data.repository.GitHubRepository
import com.ibukun.query.data.repository.GitHubRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGitHubRepository(remoteDataSource: RemoteDataSource): GitHubRepository {
        return GitHubRepositoryImpl(remoteDataSource)
    }
}
