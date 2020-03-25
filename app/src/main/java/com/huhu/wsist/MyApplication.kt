package com.huhu.wsist

import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import io.realm.Realm

class MyApplication : Application() {

    companion object {
        var DEBUG = true
    }

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        DEBUG = isDebug(this)
    }

    private fun isDebug(context: Context): Boolean {
        val pm = context.packageManager

        return try {
            val appInfo = pm.getApplicationInfo(context.packageName, 0)
            0 != (ApplicationInfo.FLAG_DEBUGGABLE and appInfo.flags)
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

}