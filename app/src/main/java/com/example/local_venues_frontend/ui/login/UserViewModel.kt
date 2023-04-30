package com.example.local_venues_frontend.ui.login

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
import com.example.local_venues_frontend.model.Auth
import com.example.local_venues_frontend.model.Session
import com.example.local_venues_frontend.model.User
import kotlinx.coroutines.launch
import retrofit2.HttpException

sealed interface UserState {
    data class LoggedIn(val session: Session): UserState

    object NotLoggedIn : UserState

    object Error : UserState

    object LoggingIn : UserState
}
class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    var userState: UserState by mutableStateOf(UserState.NotLoggedIn)
        private set

    init {
        getSessionData()
    }

    private fun getSessionData() {
        viewModelScope.launch {
            userState = UserState.NotLoggedIn
            val session: Session = userRepository.getSessionData()
            userState = try {
                if (session.isLoggedIn) {
                    UserState.LoggedIn(session)
                } else {
                    UserState.NotLoggedIn
                }
            } catch (e: HttpException) {
                UserState.Error
            }
        }
    }

    fun loginUser(auth: Auth) {
        viewModelScope.launch {
            try {
                userRepository.loginUser(auth)
                val session: Session = userRepository.getSessionData()
                userState = UserState.LoggedIn(session)
            } catch (e: HttpException) {
                userState = UserState.Error
            }
        }
    }

    fun NavigateToRegistration() {
        viewModelScope.launch {
            userState = UserState.LoggingIn
        }
    }

    fun createUser(user: User) {
        viewModelScope.launch {
            try {
                userRepository.createUser(user)
                userState = UserState.NotLoggedIn
            } catch (e: HttpException) {
                userState = UserState.Error
            }

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