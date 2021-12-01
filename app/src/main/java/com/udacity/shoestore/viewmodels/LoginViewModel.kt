package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private var _emailText = MutableLiveData<String>()
    val emailText: LiveData<String>
        get() = _emailText

    private var _passwordText = MutableLiveData<String>()
    val passwordText: LiveData<String>
        get() = _passwordText

    private var _loginState = MutableLiveData<Boolean>()
    val loginState: LiveData<Boolean>
        get() = _loginState

    init {
        _emailText.value = ""
        _passwordText.value = ""
        _loginState.value = false
    }

    fun onLogin() {
        _emailText.value = emailText.value
        _passwordText.value = passwordText.value
        _loginState.value = true
    }

    fun onRegister() {
        _emailText.value = emailText.value
        _passwordText.value = passwordText.value
        _loginState.value = true
    }

    fun logOut(){
        _loginState.value = false
    }

    
}


