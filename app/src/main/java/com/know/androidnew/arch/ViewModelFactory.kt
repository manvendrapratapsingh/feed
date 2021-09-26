package com.know.androidnew.arch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.know.androidnew.repository.UserRepository

/*viewmodelfactory to provide instance of a viewmodel inside our UI clsses*/
class ViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return KooViewModel(repository) as T
    }
}