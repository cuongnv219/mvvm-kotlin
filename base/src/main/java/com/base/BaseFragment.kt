package com.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Build
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.*
import dagger.android.support.AndroidSupportInjection

/**
 * Created by Kaz on 09:48 8/20/18
 */
abstract class BaseFragment<T : ViewDataBinding, V : ViewModelB<*>> : Fragment(), ViewTreeObserver.OnGlobalLayoutListener {

    var rootView: View? = null
    var viewDataBinding: T? = null

    protected abstract fun getViewModel(): V

    @LayoutRes
    abstract fun getLayoutId(): Int

    protected abstract fun getBindingVariable(): Int

    /**
     * update screen
     *
     * @param savedInstanceState
     */
    protected abstract fun updateUI(savedInstanceState: Bundle?)

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    override fun onGlobalLayout() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            rootView!!.viewTreeObserver.removeOnGlobalLayoutListener(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layoutId = getLayoutId()
        if (rootView != null) {
            val parent = rootView!!.parent as ViewGroup
            parent.removeView(rootView)
        } else {
            try {
                viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
                rootView = if (viewDataBinding != null) {
                    viewDataBinding!!.root
                } else {
                    inflater.inflate(layoutId, container, false)
                }
                rootView!!.viewTreeObserver.addOnGlobalLayoutListener(this)

                viewDataBinding!!.setVariable(getBindingVariable(), getViewModel())
                viewDataBinding!!.executePendingBindings()

                updateUI(savedInstanceState)
            } catch (e: InflateException) {
                e.printStackTrace()
            }
        }
        return rootView
    }

    private fun performDI() {
        AndroidSupportInjection.inject(this)
    }
}