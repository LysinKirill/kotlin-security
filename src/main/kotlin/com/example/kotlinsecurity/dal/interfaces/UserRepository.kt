package com.example.kotlinsecurity.dal.interfaces

import com.example.kotlinsecurity.model.User


interface UserRepository {
    //fun add(user: SecurityProperties.User): Long
    fun getByUserName(username: String): User?
}