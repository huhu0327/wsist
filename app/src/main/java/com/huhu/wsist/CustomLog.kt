package com.huhu.wsist

import android.util.Log

class CustomLog {
    companion object {
        const val TAG = "CustomLog"

        fun e(message: String) {
            if (MyApplication.DEBUG) Log.e(TAG, logMsg(message))
        }

        fun w(message: String) {
            if (MyApplication.DEBUG) Log.w(TAG, logMsg(message))
        }

        fun i(message: String) {
            if (MyApplication.DEBUG) Log.i(TAG, logMsg(message))
        }

        fun d(message: String) {
            if (MyApplication.DEBUG) Log.d(TAG, logMsg(message))
        }

        fun v(message: String) {
            if (MyApplication.DEBUG) Log.v(TAG, logMsg(message))
        }

        private fun logMsg(message: String): String {
            val trace = Thread.currentThread().stackTrace[4]

            return StringBuilder().apply {
                append("[${trace.fileName.replace(".java", "")}::${trace.methodName}] ${message}")
            }.toString()
        }
    }
}