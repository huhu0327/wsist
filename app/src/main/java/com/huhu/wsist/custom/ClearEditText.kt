package com.huhu.wsist.custom

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.huhu.wsist.R
import kotlin.properties.Delegates

class ClearEditText : AppCompatEditText, TextWatcher, View.OnTouchListener, View.OnFocusChangeListener {

    private var _onTouchListener: OnTouchListener? = null
    private var _onFocusChangeListener: OnFocusChangeListener? = null
    private var clearDrawable: Drawable
    private var isReady = false

    init {
        val tempDrawable = ContextCompat.getDrawable(context, R.drawable.search_clear) as Drawable
        clearDrawable = DrawableCompat.wrap(tempDrawable)
        DrawableCompat.setTintList(clearDrawable, getHintTextColors())
        clearDrawable.setBounds(0, 0, clearDrawable.intrinsicWidth, clearDrawable.intrinsicHeight)

        setClearIconVisible(false)

        super.setOnTouchListener(this)
        super.setOnFocusChangeListener(this)
        addTextChangedListener(this)

        isReady = true
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun setOnFocusChangeListener(l: OnFocusChangeListener?) {
        _onFocusChangeListener = l
    }

    override fun setOnTouchListener(l: OnTouchListener?) {
        _onTouchListener = l
    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (isReady) {
            setClearIconVisible(s?.isNotEmpty() ?: false)
        }
    }

    private fun setClearIconVisible(visible: Boolean) {
        clearDrawable.setVisible(visible, false)
        setCompoundDrawables(null, null, if (visible) clearDrawable else null, null)
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        val x = event?.x
        if (clearDrawable.isVisible && x!! > width - paddingRight - clearDrawable.intrinsicWidth) {
            if (event.action == MotionEvent.ACTION_UP) {
                setError(null)
                setText(null)
                requestFocus()
            }
            return true
        }

        return _onTouchListener?.onTouch(v, event) ?: false
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        if (hasFocus) {
            setClearIconVisible(text?.isNotEmpty() ?: false)
        } else {
            //setClearIconVisible(false)
        }

        _onFocusChangeListener?.onFocusChange(v, hasFocus)
    }

}