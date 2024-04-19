package com.example.kotlinsecurity.services.interfaces


import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthenticationServiceImpl(
    private val userDetailsService: UserDetailsService,
    private val jwtService: JwtService,
    private val authenticationManager: AuthenticationManager,
) : AuthenticationService {

    override fun login(login: String, password: String): String {
        val user = userDetailsService.loadUserByUsername(login)

        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                login,
                password
            )
        )
        val jwtToken = jwtService.generateToken(user)

        return jwtToken
    }
}