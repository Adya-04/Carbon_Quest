package com.example.carbonquest

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

data class LoginRequest(val username: String, val password: String)
data class LoginResponse(val token: String, val message: String)

interface ApiService {
    @POST("auth/login") // Adjust this according to your server's URL
    fun login(@Body request: LoginRequest): Call<LoginResponse>

}