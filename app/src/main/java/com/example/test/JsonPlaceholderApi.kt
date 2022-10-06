package com.example.test

import com.example.test.model.Model
import com.example.test.model.PostModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface JsonPlaceholderApi {
    @POST("post")
    fun sendModel(@Body postModel:PostModel): Call<PostModel>
}