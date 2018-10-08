package com.katana.mvvm.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.base.BaseActivity
import com.event.EventNextFragment
import com.google.gson.Gson
import com.katana.mvvm.BR
import com.katana.mvvm.R
import com.katana.mvvm.databinding.ActivityMainBinding
import com.katana.mvvm.model.Student
import com.katana.mvvm.ui.main.adapter.StudentAdapter
import com.utils.ListOfSomething
import com.utils.Logger
import com.widget.AppScrollListener
import com.widget.Boast
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {

    private val LOGGER = Logger.getLogger(MainActivity::class.java)

    override fun getLayoutId() = R.layout.activity_main

    override fun getBindingVariable() = BR.mainModel

    @Inject
    lateinit var mainViewModel: MainViewModel
    @Inject
    lateinit var studentAdapter: StudentAdapter
    @Inject
    lateinit var layoutManager: LinearLayoutManager

    var studentList: ArrayList<Student> = arrayListOf()

    override fun getViewModel(): MainViewModel = mainViewModel

    override fun doSomething() {

    }

    override fun updateUI(savedInstanceState: Bundle?) {
        mainViewModel.setNavigator(this)

        val gson = Gson()
        val arr = arrayListOf("1", "2")
        val s = gson.toJson(arr)

        var jj = gson.fromJson<List<String>>(s, ListOfSomething<String>(String::class.java))

        var params = mapOf<String, String>()
//        params.plus("key", "map")
//        params.map { "key" to ApiEndPoint.API_KEY }
//        params.map { "part" to "snippet" }
//        params.map { "hl" to "en_us" }
        setUpRcv()
        initStudent()
        mainViewModel.getAllCountry()

        val eventNextFragment = EventNextFragment(HomeFragment::class.java, false)

        openFragment(R.id.content_main, eventNextFragment.clazz, null, false)
    }

    private fun setUpRcv() {
        rcv.setHasFixedSize(true)
        rcv.layoutManager = layoutManager
        rcv.adapter = studentAdapter

        studentAdapter.setOnItemClick(object : StudentAdapter.OnItemClick {
            override fun onItemClickListener(view: View, pos: Int) {
                LOGGER.error("$pos")
                toast(pos.toString())
            }
        })
        rcv.addOnScrollListener(object : AppScrollListener() {

            override fun onLoadMore() {
            }
        })
        binding.btnFuck.setOnClickListener {
            Boast.makeText(this@MainActivity, "fuck").show()
        }
    }

    private fun initStudent() {
        for (i in 0..10) {
            val student = Student("Nguyen Van $i", "$i")
            studentList.add(student)
        }

        studentAdapter.setStudentList(studentList)
    }

    override fun getLayoutIdLoading(): Int {
        return R.layout.item_student
    }
}
