package com.example.myapplication5.ViewModels

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

    class AuthenticationViewModel : ViewModel() {
        private val auth: FirebaseAuth = FirebaseAuth.getInstance()

        fun isLoggedIn(): Boolean {
            val getCurrentUser = null
            return false
        }

        fun login(email: String, password: String, param: (Any, Any) -> Unit) {
            auth.signInWithEmailAndPassword(email, password)
        }

        fun logout() {
            auth.signOut()
        }

        fun register(email: String, password: String, callback: (Boolean, String?) -> Unit) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        callback(true, null) // Registration successful
                    } else {
                        callback(false, task.exception?.message ?: "Registration failed")
                    }
                }
        }
    }
