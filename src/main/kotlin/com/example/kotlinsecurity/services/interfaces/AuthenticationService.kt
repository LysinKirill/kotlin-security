package com.example.kotlinsecurity.services.interfaces


interface AuthenticationService {
    fun login(login: String, password: String): String
}