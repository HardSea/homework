package com.pmacademy.razvii_pt8

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class MathResultFragment : Fragment(R.layout.mathresult_fragment) {

    private val TAG = MathResultFragment::class.java.simpleName
    private lateinit var localReceiver: BroadcastReceiver

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onCreateView in Fragment")

        val filter = IntentFilter()
        filter.addAction(BROADCAST_MATH_RESULT)
        localReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (intent != null) {
                    val result = intent.getDoubleExtra("math_result_to_fragment", 0.0)
                    view.findViewById<TextView>(R.id.TextViewWithResultFragment).text = result.toString()
                }
            }
        }
        context?.registerReceiver(localReceiver, filter)
    }

    companion object {
        fun newInstance(): MathResultFragment = MathResultFragment()
    }
}