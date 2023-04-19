package com.example.local_venues_frontend.ui.login

import android.text.Spannable.Factory
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.local_venues_frontend.LocalVenuesApplication
import com.example.local_venues_frontend.data.UserRepository
import com.example.local_venues_frontend.model.Session
import com.example.local_venues_frontend.model.User
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.HttpException

sealed interface UserState {
    data class LoggedIn(val loggedIn: Boolean) : UserState

    object NotLoggedIn : UserState

    object Error : UserState
}
class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    var userState: UserState by mutableStateOf(UserState.NotLoggedIn)
        private set

    init {
        getSessionData()
    }

    fun getSessionData() {
        viewModelScope.launch {
            userState = UserState.NotLoggedIn
            userState = try {
                val session = userRepository.getSessionData()
                UserState.LoggedIn(session.isLoggedIn)
            } catch (e: HttpException) {
                UserState.Error
            }
        }
    }

    fun createUser(user: User) {
        viewModelScope.launch {
            userRepository.createUser(user)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as LocalVenuesApplication)
                val userRepository = application.container.userRepository
                UserViewModel(userRepository = userRepository)
            }
        }
    }
}