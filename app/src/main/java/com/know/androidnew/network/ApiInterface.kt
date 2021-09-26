package com.know.androidnew.network

import com.know.androidnew.model.KooFeedModel
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {
    /*subspend function to call api
    * this function is reponsible for making request to the end point given to us*/
    @GET("/public/v1/posts")
    suspend fun getUsersNew() : Response<KooFeedModel>
}