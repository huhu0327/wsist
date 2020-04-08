package com.huhu.wsist.api

import android.app.Activity
import android.content.Intent
import androidx.core.app.ActivityCompat.startActivityForResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.Scope
import com.google.android.gms.tasks.OnSuccessListener
import com.google.api.client.extensions.android.http.AndroidHttp
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.api.client.json.gson.GsonFactory
import com.google.api.services.drive.Drive
import com.google.api.services.drive.DriveScopes
import com.google.gson.Gson
import com.huhu.wsist.util.CustomLog
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object GoogleDriveAPI {
    var activity: Activity? = null
        private set

    enum class REQUEST_CODE(val code: Int) {
        SIGN_IN(1),
        OPEN_DOCUMENT(2)
    }

    fun requestSingIn(activity: Activity) {
        val signInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestScopes(Scope(DriveScopes.DRIVE_FILE))
            .build()

        val client = GoogleSignIn.getClient(activity, signInOptions)

        this.activity = activity
        startActivityForResult(this.activity!!, client.signInIntent, REQUEST_CODE.SIGN_IN.code, null)
    }

    fun handleSignInIntent(intent: Intent, successCallback: (() -> Unit)? = null) {
        GoogleSignIn.getSignedInAccountFromIntent(intent)
            .addOnSuccessListener {
                val credential =
                    GoogleAccountCredential.usingOAuth2(this.activity, Collections.singleton(DriveScopes.DRIVE_FILE))

                credential.selectedAccount = it.account

                val drive = Drive.Builder(
                    AndroidHttp.newCompatibleTransport(),
                    GsonFactory(),
                    credential
                )
                    .setApplicationName("wsist")
                    .build()

                successCallback?.invoke()

            }
            .addOnFailureListener {
                CustomLog.e(it.toString())
            }
    }

    fun readFile() {

    }

    fun writeFile() {

    }

}