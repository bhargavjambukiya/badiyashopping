package com.app.badiyashopping.viewmodels

import androidx.lifecycle.ViewModel
import com.app.badiyashopping.repository.AuthRepository

class AuthViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    /*  private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
      val loginResponse: LiveData<Resource<LoginResponse>>
          get() = _loginResponse

      fun login(
          email: String,
          password: String
      ) = viewModelScope.launch {
          _loginResponse.value = repository.login(email, password)
      }

      fun saveAuthToken(token: String) = viewModelScope.launch {
          repository.saveAuthToken(token)
      }*/
}