package com.know.androidnew

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
public class KooApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}