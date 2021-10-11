package com.know.androidnew.module

import com.know.androidnew.network.ApiInterface
import com.know.androidnew.network.NetworkHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideNetWorkApi(networkHelper: NetworkHelper): ApiInterface{
      return networkHelper.getRetrofitInstance().create(ApiInterface::class.java)
    }
}