package com.huhu.wsist

import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.huhu.wsist.api.MusicAPI
import com.huhu.wsist.model.Music
import com.huhu.wsist.util.CustomLog
import io.realm.Realm
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyApplication : Application() {

    companion object {
        var DEBUG = true
    }

    override fun onCreate() {
        super.onCreate()

        MusicAPI.get().getMusicInfoFromKYUsingSinger("빅뱅").enqueue(object : Callback<List<Music>> {
            override fun onFailure(call: Call<List<Music>>, t: Throwable) {
                CustomLog.d(t.message.toString())
            }

            override fun onResponse(call: Call<List<Music>>, response: Response<List<Music>>) {
                if (response.isSuccessful) {
                    val music = response.body()
                    if (music != null) {
                        for (m in music) {
                            CustomLog.d("${m.title} ${m.singer} ${m.no}")
                        }
                    }
                }
            }

        })

        MusicAPI.get().getMusicInfoFromTJUsingSinger("빅뱅").enqueue(object : Callback<List<Music>> {
            override fun onFailure(call: Call<List<Music>>, t: Throwable) {
                CustomLog.d(t.message.toString())
            }

            override fun onResponse(call: Call<List<Music>>, response: Response<List<Music>>) {
                if (response.isSuccessful) {
                    val music = response.body()
                    if (music != null) {
                        for (m in music) {
                            CustomLog.d("${m.title} ${m.singer} ${m.no}")
                        }
                    }
                }
            }

        })

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