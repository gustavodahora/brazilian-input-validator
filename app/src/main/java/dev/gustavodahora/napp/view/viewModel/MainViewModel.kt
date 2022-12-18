package dev.gustavodahora.napp.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var toastStatus = MutableLiveData<Boolean>()

    fun validate() {
        toastStatus.value = true
    }
}