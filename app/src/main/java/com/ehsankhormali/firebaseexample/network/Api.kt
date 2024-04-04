package com.ehsankhormali.firebaseexample.network

import retrofit2.http.GET
import retrofit2.http.Query
import com.ehsankhormali.firebaseexample.data.User
import javax.inject.Singleton

@Singleton
interface Api {
    @GET("")
    suspend fun getUserProfile(@Query("userUid") userUid:String): User
}