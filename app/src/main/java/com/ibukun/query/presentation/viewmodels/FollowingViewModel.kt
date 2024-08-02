package com.ibukun.query.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibukun.query.data.model.User
import com.ibukun.query.domain.usecase.GetFollowingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FollowingViewModel @Inject constructor(
    private val getFollowingUseCase: GetFollowingUseCase
) : ViewModel() {
    private val _following = MutableLiveData<List<User>>()
    val following: LiveData<List<User>> get() = _following

    fun getFollowing(username: String) {
        viewModelScope.launch {
            val result = getFollowingUseCase(username)
            _following.value = result
        }
    }
}
