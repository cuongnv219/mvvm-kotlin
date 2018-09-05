package com.base

import android.app.Dialog
import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.RelativeLayout
import dagger.android.support.AndroidSupportInjection

/**
 * Created by Kaz on 11:32 7/20/18
 */
abstract class BaseDialog<T : ViewDataBinding, V : ViewModel> : DialogFragment() {

    lateinit var viewDataBinding: T

    abstract fun getBindingVariable(): Int

    protected abstract fun getViewModel(): V

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun updateUI(savedInstanceState: Bundle?)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val root = RelativeLayout(activity)
        root.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(root)

        dialog.window?.let {
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            it.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }

        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        performDependencyInjection()

        viewDataBinding.setVariable(getBindingVariable(), getViewModel())
        viewDataBinding.executePendingBindings()
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUI(savedInstanceState)
    }

    override fun show(fragManager: FragmentManager, tag: String) {
        val transaction = fragManager.beginTransaction()
        val prev: Fragment? = fragManager.findFragmentByTag(tag)
        prev?.let { transaction.remove(it) }
        transaction.addToBackStack(null)
        super.show(transaction, tag)
    }

    @Throws()
    open fun dismissDialog(fragManager: FragmentManager, tag: String) {
        val frag: Fragment? = fragManager.findFragmentByTag(tag)
        frag?.let {
            fragManager.beginTransaction()
                    .disallowAddToBackStack()
                    .remove(it)
                    .commitAllowingStateLoss()
        }
    }

    @Throws()
    open fun dismissDialog(fragManager: FragmentManager, tag: String, aniIn: Int, aniOut: Int) {
        val frag: Fragment? = fragManager.findFragmentByTag(tag)
        frag?.let {
            fragManager.beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(aniIn, aniOut)
                    .remove(it)
                    .commitAllowingStateLoss()
        }
    }

    private fun performDependencyInjection() {
        AndroidSupportInjection.inject(this)
    }
}