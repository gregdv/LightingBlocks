package com.gfdevs.lightingblocks.Utilities
import android.content.Context
class SharedPrefs(context: Context) {

    val PREFS_FILENAME = "prefs"
    val prefs = context.getSharedPreferences(PREFS_FILENAME, 0)

    val LAST_LEVEL = "lastLevel"

    var lastLevel: Int
        get() = prefs.getInt(LAST_LEVEL,0)
        set(value) = prefs.edit().putInt(LAST_LEVEL, value).apply()
}
