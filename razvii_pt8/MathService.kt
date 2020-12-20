package com.pmacademy.razvii_pt8

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MathService : Service() {
    private val TAG = MathService::class.java.simpleName



    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG,"Service started")

        val result = calculateMath()

        val intentResult = Intent()
        intentResult.action = BROADCAST_MATH_RESULT
        intentResult.putExtra("math_result_to_fragment", result)
        Log.d(TAG,"Service sending broadcast")
        sendBroadcast(intentResult)

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    fun calculateMath(): Double {
        return 884.63375 / 8.75
    }
}