package com.know.androidnew.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/*Singleton class to access retrofit object including the base url
* this class contains Retrofit Builder and Gson Factory
* GsonConverterFactory is responsble to convert Json to Data Objects  */
object RetrofitHelper {


    private const val BASE_URL = "https://gorest.co.in/"

    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }


}