package com.know.androidnew.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.know.androidnew.model.KooFeedModel
import com.know.androidnew.network.ApiInterface

/*UserRepository class is  Data source class for the application
* fetching data from network and posting data to the model
* Repository is the common sources of data include local databases, cache,
* and online servers. Using a repository allows us  to manage data more effectively*/
class UserRepository(private val apiInterface: ApiInterface) {
    private val userLiveData= MutableLiveData<KooFeedModel>()
    val userData:LiveData<KooFeedModel>
    get() = userLiveData;
    suspend fun getUser(){
        val  result= apiInterface.getUsersNew()
        if( result?.body()!=null){
           userLiveData.postValue(result.body())
        }
    }
}