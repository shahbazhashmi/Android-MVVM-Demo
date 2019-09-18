package matrixsystems.mvvm.main

import android.app.Application
import android.text.TextUtils
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import matrixsystems.sharedcode.livedata.SingleLiveEvent

/**
 * Created by Shahbaz Hashmi on 2019-09-18.
 */
class MainViewModel(val appContext: Application) : AndroidViewModel(appContext) {

    private val TAG = "MainViewModel"


    var text = ObservableField<String>("")

    var submitEvent = SingleLiveEvent<Boolean>()

    init {

    }


    fun onSubmitClick(v : View) {
        if(!TextUtils.isEmpty(text.get())) {
            submitEvent.value = true
        }
    }

}