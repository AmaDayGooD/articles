package com.example.articles.authorization

import com.example.articles.user.AuthRequest
import com.example.articles.user.User
import retrofit2.http.*

interface MainApi {
    @POST("auth/login")
    suspend fun auth(@Body authRequest: AuthRequest) : User

}