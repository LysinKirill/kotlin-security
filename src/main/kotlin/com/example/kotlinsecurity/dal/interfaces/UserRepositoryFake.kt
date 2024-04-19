package com.example.kotlinsecurity.dal.interfaces

import com.example.kotlinsecurity.filters.Role
import com.example.kotlinsecurity.model.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryFake : UserRepository {
    override fun getByUserName(username: String): User? {
        if (username == "admin")
            return User(
                "admin",

                BCryptPasswordEncoder().encode("admin_pass"),
                Role.ADMIN
            )

        if (username == "user")
            return User("user",
                BCryptPasswordEncoder().encode("user_pass"),
                Role.USER)

        return null
    }
}