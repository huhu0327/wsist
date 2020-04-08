package com.huhu.wsist.util

import android.content.Context
import android.content.pm.PackageManager
import android.util.Base64
import java.security.MessageDigest

class HashKey(private val context: Context) {

    fun print() {
        try {
            val info =
                context.packageManager.getPackageInfo(context.packageName, PackageManager.GET_SIGNING_CERTIFICATES)
            val signatures = info.signingInfo.apkContentsSigners
            val md = MessageDigest.getInstance("SHA")
            for (signature in signatures) {
                val md: MessageDigest
                md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                val key = String(Base64.encode(md.digest(), 0))
                CustomLog.d("Hash key: $key")
            }
        } catch (e: Exception) {
            CustomLog.e("name not found ${e.toString()}")
        }
    }

}