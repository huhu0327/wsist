package com.huhu.wsist.custom

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import com.huhu.wsist.R

class TwoTextButton : LinearLayout {

    private lateinit var background: LinearLayout
    private lateinit var subject: TextView
    private lateinit var content: TextView

    init {
        initView()
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        getAttrs(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        getAttrs(attrs, defStyle)
    }

    private fun initView() {
        inflate(context, R.layout.custom_twotextbutton, this)

        background = findViewById(R.id.two_background)
        subject = findViewById(R.id.two_subject)
        content = findViewById(R.id.two_content)
    }

    private fun getAttrs(attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TwoTextButton)
        setTypeArray(typedArray)
    }

    private fun getAttrs(attrs: AttributeSet, defStyle: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TwoTextButton, defStyle, 0)
        setTypeArray(typedArray)
    }

    private fun setTypeArray(typedArray: TypedArray) {
//        val bg_resID = typedArray.getResourceId(R.styleable.TwoTextButton_bg, 0)
//        background.setBackgroundResource(bg_resID)

        val subject_resID = typedArray.getString(R.styleable.TwoTextButton_subject_text)
        subject.text = subject_resID

        //val subjectColor = typedArray.getColor(R.styleable.TwoTextButton_subject_textColor, 0)
        //subject.setTextColor(subjectColor)

        val content_resID = typedArray.getString(R.styleable.TwoTextButton_content_text)
        content.text = content_resID

        typedArray.recycle()
    }
}