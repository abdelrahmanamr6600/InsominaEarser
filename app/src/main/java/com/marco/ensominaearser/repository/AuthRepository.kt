package com.marco.ensominaearser.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.marco.ensominaearser.R
import io.github.muddz.styleabletoast.StyleableToast


class AuthRepository(private var application: Application) {
    private  var  user :MutableLiveData<FirebaseUser> = MutableLiveData()
    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    fun getCurrentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }
    fun getFirebaseUserMutableLiveData(): MutableLiveData<FirebaseUser> {
        return user
    }

    fun signup(email:String,password:String){
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
              user.postValue(firebaseAuth.currentUser)
            StyleableToast.makeText(application, "Your Account Was Created Successfully...Please Login", Toast.LENGTH_LONG, R.style.mytoast).show();
        }.addOnFailureListener {

            Log.d("SignInError",it.message.toString())
        }
    }
    fun login(email:String,password:String){
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            user.postValue(firebaseAuth.currentUser)
        }.addOnFailureListener {

            Toast.makeText(application.applicationContext,it.message,Toast.LENGTH_LONG).show()
        }
    }

}