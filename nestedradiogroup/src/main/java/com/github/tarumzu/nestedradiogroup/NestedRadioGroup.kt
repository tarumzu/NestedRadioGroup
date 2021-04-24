package com.github.tarumzu.nestedradiogroup

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RadioButton
import androidx.constraintlayout.widget.ConstraintLayout

class NestedRadioGroup(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {
    private val radioButtons = mutableMapOf<Int, RadioButton>()
    private var checkedId = -1
    private var onCheckedChangeListener: OnCheckedChangeListener? = null
    private var onClickListener: OnClickListener? = null

    override fun addView(child: View, index: Int, params: ViewGroup.LayoutParams?) {
        super.addView(child, index, params)
        findRadioButtons(child)
    }

    private fun findRadioButtons(child: View) {
        if (child is RadioButton) {
            child.setOnCheckedChangeListener { buttonView: CompoundButton, isChecked: Boolean ->
                if (isChecked.not()) return@setOnCheckedChangeListener

                if (checkedId != -1) radioButtons[checkedId]?.isChecked = false
                radioButtons[buttonView.id]?.isChecked = true
                checkedId = buttonView.id
                onCheckedChangeListener?.onCheckedChanged(radioButtons, child.id)
            }
            child.setOnClickListener {
                onClickListener?.onClick(it)
            }
            child.id.let {
                radioButtons.put(it, child)
                if (child.isChecked) {
                    radioButtons[it]?.isChecked = true
                    checkedId = it
                }
            }
        } else if (child is ViewGroup) {
            for (i in 0 until child.childCount) {
                findRadioButtons(child.getChildAt(i))
            }
        }
    }

    fun setOnCheckedChangeListener(onCheckedChangeListener: OnCheckedChangeListener?) {
        this.onCheckedChangeListener = onCheckedChangeListener
    }

    fun setOnClickListener(onClickListener: OnClickListener?) {
        this.onClickListener = onClickListener
    }

    interface OnCheckedChangeListener {
        fun onCheckedChanged(var1: MutableMap<Int, RadioButton>, var2: Int)
    }

    interface OnClickListener {
        fun onClick(var1: View?)
    }
}
