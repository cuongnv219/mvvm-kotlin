package com.katana.mvvm.main

import android.os.Bundle
import android.util.Log
import com.base.BaseActivity
import com.katana.mvvm.BR
import com.katana.mvvm.R
import com.katana.mvvm.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {

    override fun getLayoutId() = R.layout.activity_main

    override fun getBindingVariable() = BR.mainModel

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun getViewModel(): MainViewModel = mainViewModel

    override fun doSomething() {
        Log.e("ff", "doSomething")
    }

    override fun updateUI(savedInstanceState: Bundle?) {
        Log.e("ff", "fff")
        println("Fuckgggg")
        mainViewModel.setNavigator(this)
    }
}
