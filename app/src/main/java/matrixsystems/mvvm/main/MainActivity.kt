package matrixsystems.mvvm.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import matrixsystems.mvvm.R
import matrixsystems.mvvm.databinding.ActivityMainBinding
import matrixsystems.sharedcode.livedata.getViewModel

class MainActivity : AppCompatActivity() {


    lateinit var binding : ActivityMainBinding

    val viewModel: MainViewModel by lazy {
        getViewModel {
            MainViewModel(this.application)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setVm(viewModel)


        viewModel.submitEvent.observe(this, Observer<Boolean> {
            if(it!!) {
                Toast.makeText(this, viewModel.text.get(), Toast.LENGTH_SHORT).show()
            }
        })
    }
}
