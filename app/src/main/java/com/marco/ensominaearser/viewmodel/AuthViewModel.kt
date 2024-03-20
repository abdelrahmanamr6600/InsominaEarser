package com.marco.ensominaearser.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.marco.ensominaearser.repository.AuthRepository

class AuthViewModel(private var application: Application):ViewModel() {

    private var authRepository = AuthRepository(application)
    private var user:MutableLiveData<FirebaseUser> =authRepository.getFirebaseUserMutableLiveData()
    private var currentUser:FirebaseUser? = authRepository.getCurrentUser()

    fun getFirebaseUserMutableLiveData(): MutableLiveData<FirebaseUser> {
        return user
    }

    fun getCurrentUser(): FirebaseUser? {
        return currentUser
    }

    fun signUp(email: String, pass: String) {
        authRepository.signup(email, pass)
    }

    fun signIn(email: String, pass: String) {
        authRepository.login(email, pass)
    }

}