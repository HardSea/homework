package com.pmacademy.razvii_pt8

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.LayoutFragment, MathResultFragment.newInstance())
                .commit()

        val startTextView = findViewById<TextView>(R.id.StartTextViewFragment)
        startTextView.setOnClickListener {
            Log.d(TAG, "TextView clicked")
            val serviceIntent = Intent(this, MathService::class.java)
            startService(serviceIntent)
        }
    }
}
