package com.know.androidnew.arch

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.know.androidnew.model.KooFeedModel
import com.know.androidnew.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*View model class to hold the data*/
class KooViewModel(private val repository: UserRepository) : ViewModel() {


    init {
       /*  calling coroutine here for executing task
          in background so that main thred will be free */

        viewModelScope.launch(Dispatchers.IO){
            repository.getUser()

        }
    }

    /*giving live data access */
    val userliveData: LiveData<KooFeedModel>
    get() = repository.userData

}

