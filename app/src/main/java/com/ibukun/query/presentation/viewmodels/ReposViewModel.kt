package com.ibukun.query.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibukun.query.data.model.Repo
import com.ibukun.query.domain.usecase.GetReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReposViewModel @Inject constructor(
    private val getReposUseCase: GetReposUseCase
) : ViewModel() {
    private val _repos = MutableLiveData<List<Repo>>()
    val repos: LiveData<List<Repo>> get() = _repos

    fun getRepos(username: String) {
        viewModelScope.launch {
            val result = getReposUseCase(username)
            _repos.value = result
        }
    }
}
