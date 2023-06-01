package com.nastirlex.superfit.net

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.nastirlex.superfit.presentation.utils.Constants.ACCESS_TOKEN_KEY
import com.nastirlex.superfit.presentation.utils.Constants.CREDENTIALS_DEFAULT_VALUE
import com.nastirlex.superfit.presentation.utils.Constants.CRUNCH_KEY
import com.nastirlex.superfit.presentation.utils.Constants.EXERCISES_DEFAULT_VALUE
import com.nastirlex.superfit.presentation.utils.Constants.EXERCISES_INCREASE_VALUE
import com.nastirlex.superfit.presentation.utils.Constants.FIRST_RUN_DEFAULT_VALUE
import com.nastirlex.superfit.presentation.utils.Constants.FIRST_RUN_KEY
import com.nastirlex.superfit.presentation.utils.Constants.PASSWORD_KEY
import com.nastirlex.superfit.presentation.utils.Constants.PLANK_DEFAULT_VALUE
import com.nastirlex.superfit.presentation.utils.Constants.PLANK_KEY
import com.nastirlex.superfit.presentation.utils.Constants.PUSH_UPS_KEY
import com.nastirlex.superfit.presentation.utils.Constants.RUNNING_DEFAULT_VALUE
import com.nastirlex.superfit.presentation.utils.Constants.RUNNING_INCREASE_VALUE
import com.nastirlex.superfit.presentation.utils.Constants.RUNNING_KEY
import com.nastirlex.superfit.presentation.utils.Constants.SQUATS_KEY
import com.nastirlex.superfit.presentation.utils.Constants.USERNAME_KEY
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject




class EncryptedSharedPref @Inject constructor(@ApplicationContext context: Context) {
    private val masterKeyAlias = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        "preferences",
        masterKeyAlias,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    // ACCESS TOKEN
    fun saveAccessToken(accessToken: String) {
        with(editor) {
            putString(ACCESS_TOKEN_KEY, accessToken)
            apply()
        }
    }

    fun getAccessToken(): String {
        return sharedPreferences.getString(ACCESS_TOKEN_KEY, CREDENTIALS_DEFAULT_VALUE).toString()
    }

    fun deleteAccessToken() {
        with(editor) {
            remove(ACCESS_TOKEN_KEY)
            apply()
        }
    }

    // USERNAME
    fun saveUsername(username: String) {
        with(editor) {
            putString(USERNAME_KEY, username)
            apply()
        }
    }

    fun getUsername(): String {
        return sharedPreferences.getString(USERNAME_KEY, CREDENTIALS_DEFAULT_VALUE).toString()
    }

    fun deleteUsername() {
        with(editor) {
            remove(USERNAME_KEY)
            apply()
        }
    }

    // PASSWORD
    fun savePassword(password: String) {
        with(editor) {
            putString(PASSWORD_KEY, password)
            apply()
        }
    }

    fun getPassword(): String {
        return sharedPreferences.getString(PASSWORD_KEY, CREDENTIALS_DEFAULT_VALUE).toString()
    }

    fun deletePassword() {
        with(editor) {
            remove(PASSWORD_KEY)
            apply()
        }
    }

    // FIRST RUN
    fun saveFirstRun(isFirstRun: Boolean) {
        with(editor) {
            putBoolean(FIRST_RUN_KEY, isFirstRun)
            apply()
        }
    }

    fun getFirstRun(): Boolean {
        return sharedPreferences.getBoolean(FIRST_RUN_KEY, FIRST_RUN_DEFAULT_VALUE)
    }

    // ACCESS TOKEN IS EXPIRED
    fun getIsTokenExpired(): Boolean {
        return sharedPreferences.getBoolean("isTokenExpired", false)
    }

    fun saveIsTokenExpired(isTokenExpired: Boolean) {
        with(editor) {
            putBoolean("isTokenExpired", isTokenExpired)
        }
    }


    // CRUNCH
    fun getCrunch(): Int {
        return sharedPreferences.getInt(CRUNCH_KEY, EXERCISES_DEFAULT_VALUE)
    }

    fun increaseCrunch() {
        with(editor) {
            putInt(CRUNCH_KEY, getCrunch() + EXERCISES_INCREASE_VALUE)
        }
    }

    // SQUATS
    fun getSquats(): Int {
        return sharedPreferences.getInt(SQUATS_KEY, EXERCISES_DEFAULT_VALUE)
    }

    fun increaseSquats() {
        with(editor) {
            putInt(SQUATS_KEY, getSquats() + EXERCISES_INCREASE_VALUE)
        }
    }

    // PLANK
    fun getPlank(): Int {
        return sharedPreferences.getInt(PLANK_KEY, PLANK_DEFAULT_VALUE)
    }

    fun increasePLank() {
        with(editor) {
            putInt(PLANK_KEY, getPlank() + EXERCISES_INCREASE_VALUE)
        }
    }

    // PUSH-UPS
    fun getPushUps(): Int {
        return sharedPreferences.getInt(PUSH_UPS_KEY, EXERCISES_DEFAULT_VALUE)
    }

    fun increasePushUps() {
        with(editor) {
            putInt(PUSH_UPS_KEY, getPushUps() + EXERCISES_INCREASE_VALUE)
        }
    }

    // RUNNING
    fun getRunning(): Int {
        return sharedPreferences.getInt(RUNNING_KEY, RUNNING_DEFAULT_VALUE)
    }

    fun increaseRunning() {
        with(editor) {
            putInt(RUNNING_KEY, getRunning() + RUNNING_INCREASE_VALUE)
        }
    }

}