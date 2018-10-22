package com.base

import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by Kaz on 20:35 9/1/18
 */
open class ViewPagerAdapter(fm: FragmentManager, private val fragmentList: List<Fragment>, private val titles:
List<String>) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return this.fragmentList[position]
    }

    override fun getCount(): Int {
        return this.fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return this.titles[position]
    }

    override fun saveState(): Parcelable? {
        return null
    }
}
