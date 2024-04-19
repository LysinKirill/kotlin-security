package com.example.kotlinsecurity.controllers


import com.example.kotlinsecurity.services.interfaces.AuthenticationService
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class GreetingController(
    private val authenticationService: AuthenticationService
) {
    @PostMapping("/login")
    fun login(login: String, password: String): ResponseEntity<String> {
        return ResponseEntity.ok(authenticationService.login(login, password))
    }

    @GetMapping("/hello-all")
    fun greetAll():ResponseEntity<String> {
        return ResponseEntity.ok("Hello, anyone!")
    }

    @GetMapping("/hello-user")
    fun helloUser(): ResponseEntity<String> {
        return ResponseEntity.ok("Hello, user!")
    }

    @GetMapping("/hello-admin")
    fun helloAdmin(): ResponseEntity<String> {
        return ResponseEntity.ok("Hello, admin!")
    }
}