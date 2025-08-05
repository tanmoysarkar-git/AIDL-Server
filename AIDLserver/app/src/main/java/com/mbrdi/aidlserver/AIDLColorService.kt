package com.mbrdi.aidlserver

import android.R
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.util.Objects

class AIDLColorService : Service() {
    private val TAG = "AIDL Server"
    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    private val binder = object : IAIDLColorInterface.Stub()
    {
        override fun getColor(): Int {
            val rnd = java.util.Random()
            val color = android.graphics.Color.argb(
                255,
                rnd.nextInt(256),
                rnd.nextInt(256),
                rnd.nextInt(256)
            )
            Log.d(TAG, "getColor is called for color value : $color")
            return color
        }

    }
}