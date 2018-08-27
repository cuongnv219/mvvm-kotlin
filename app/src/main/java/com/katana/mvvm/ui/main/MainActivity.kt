package com.katana.mvvm.ui.main

import android.os.Bundle
import android.util.Log
import com.base.BaseActivity
import com.google.gson.Gson
import com.katana.mvvm.BR
import com.katana.mvvm.R
import com.katana.mvvm.databinding.ActivityMainBinding
import com.utils.ListOfSomething
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {

//    private val K_LOGGER = Logger.getLogger(MainActivity::class.java)

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

        var gson = Gson()
        var arr = arrayListOf("1", "2")
        var s = gson.toJson(arr)

        var jj = gson.fromJson<List<String>>(s, ListOfSomething<String>(String::class.java))

        print(s)
    }
}
