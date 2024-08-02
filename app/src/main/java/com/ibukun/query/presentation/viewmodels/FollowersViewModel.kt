package com.ibukun.query.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibukun.query.data.model.User
import com.ibukun.query.domain.usecase.GetFollowersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FollowersViewModel @Inject constructor(
    private val getFollowersUseCase: GetFollowersUseCase
) : ViewModel() {
    private val _followers = MutableLiveData<List<User>>()
    val followers: LiveData<List<User>> get() = _followers

    fun getFollowers(username: String) {
        viewModelScope.launch {
            val result = getFollowersUseCase(username)
            _followers.value = result
        }
    }
}
