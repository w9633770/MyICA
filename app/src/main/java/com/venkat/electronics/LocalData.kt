package com.venkat.electronics

import android.content.Context
import android.content.SharedPreferences


class LocalData {
     var _context: Context? = null
     lateinit var prefs: SharedPreferences
     var editor: SharedPreferences.Editor? = null
     constructor(_context: Context?) {
         this._context = _context
         if (_context != null) {
             prefs = _context.getSharedPreferences(_context.getString(R.string.app_name), Context.MODE_PRIVATE)
         }
         editor = prefs.edit()
     }

     companion object {
         const val USER_TOKEN = "user_token"
        const val USER_NAME = "user_name"
        const val USER_ID = "user_id"
        const val USER_EMAIL = "user_email"
        const val USER_MOBILE= "user_mobile"
        const val USER_ADDRESS= "user_address"
        const val USER_ADDRESSID= "user_addressid"
        const val USER_CATID= "user_catid"
        const val USER_SUBCATID= "user_subid"
        const val USER_SUBNAME= "user_subname"
        const val USER_CATNAME= "user_catname"
        const val USER_AVALIBLE= "user_avaliable"
        const val USER_NOTIFICATIONAVALIBLE= "user_notificationavaliable"
        const val USER_IMAGE= "user_image"
        const val USER_REGISTRATION= "user_registrationstatus"
        const val USER_PENDING_STATUS= "user_productstatus"
        const val LAT= "lat"
        const val LANG= "lang"
    }


    fun saveLatLang( lat: String, lang: String) {
        LatLang( LAT, lat, LANG,lang)
    }

    fun LatLang(lat: String, latitute: String, lang: String, langitude: String) {
        editor!!.putString(LAT, latitute)
        editor!!.putString(LANG, langitude)
        editor!!.apply()
    }

    fun saveAuthToken( username: String, id: String, email: String, mobile: String, token: String, address:String) {
        saveString( USER_NAME, username, USER_ID,id, USER_EMAIL,email, USER_MOBILE, mobile,
            USER_TOKEN,token, USER_ADDRESS,address)
    }

    fun saveString(
        USER_NAME: String,
        username: String,
        USER_ID: String,
        id: String,
        USER_EMAIL: String,
        email: String,
        USER_MOBILE: String,
        mobile: String,
        USER_TOKEN: String,
        token: String,
        USER_ADDRESS :String,
        address: String

    ) {
      //  editor!!.putString(key, value)
        editor!!.putString(USER_NAME, username)
        editor!!.putString(USER_ID, id)
        editor!!.putString(USER_EMAIL, email)
        editor!!.putString(USER_MOBILE, mobile)
        editor!!.putString(USER_TOKEN, token)
        editor!!.putString(USER_ADDRESS, address)
        editor!!.apply()

    }



    fun getSingleField(key: String?): String? {
         return prefs.getString(key, null)
     }


    fun getUserDetails(): HashMap<String, String>? {
        //Use hashmap to store user credentials
        val user = HashMap<String, String>()
        prefs.getString(USER_TOKEN, null)?.let { user.put(USER_TOKEN, it) }
        prefs.getString(USER_ID, null)?.let { user.put(USER_ID, it) }
        prefs.getString(USER_NAME, null)?.let { user.put(USER_NAME, it) }
        prefs.getString(USER_EMAIL, null)?.let { user.put(USER_EMAIL, it) }
        prefs.getString(USER_MOBILE, null)?.let { user.put(USER_MOBILE, it) }
        prefs.getString(USER_ADDRESS, null)?.let { user.put(USER_ADDRESS, it) }
        prefs.getString(USER_ADDRESSID, null)?.let { user.put(USER_ADDRESSID, it) }
        prefs.getString(USER_CATID, null)?.let { user.put(USER_CATID, it) }
        prefs.getString(USER_AVALIBLE, null)?.let { user.put(USER_AVALIBLE, it) }
        prefs.getString(USER_NOTIFICATIONAVALIBLE, null)?.let { user.put(USER_NOTIFICATIONAVALIBLE, it) }
        prefs.getString(USER_IMAGE, null)?.let { user.put(USER_IMAGE, it) }
        prefs.getString(USER_REGISTRATION, null)?.let { user.put(USER_REGISTRATION, it) }
        prefs.getString(LAT, null)?.let { user.put(LAT, it) }
        prefs.getString(LANG, null)?.let { user.put(LANG, it) }

        return user
    }


     fun getString(context: Context, key: String): String? {
        val prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        return prefs.getString(Companion.USER_TOKEN, null)
    }

    fun clearData(context: Context){
        val editor = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE).edit()
        editor.clear()
        editor.apply()
    }



}