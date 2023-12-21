package com.sd.demo.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sd.demo.activity.databinding.ActivityMainBinding
import com.sd.lib.activity.fLastActivity

class MainActivity : AppCompatActivity() {
    private val _binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(_binding.root)
        _binding.btn.setOnClickListener { finish() }
        logMsg { "onCreate last activity:$fLastActivity" }
    }

    override fun onStart() {
        super.onStart()
        logMsg { "onStart last activity:$fLastActivity" }
    }

    override fun onResume() {
        super.onResume()
        logMsg { "onResume last activity:$fLastActivity" }
    }

    override fun onPause() {
        super.onPause()
        logMsg { "onPause last activity:$fLastActivity" }
    }

    override fun onStop() {
        super.onStop()
        logMsg { "onStop last activity:$fLastActivity" }
    }

    override fun onDestroy() {
        super.onDestroy()
        logMsg { "onDestroy last activity:$fLastActivity" }
    }
}

inline fun logMsg(block: () -> Any?) {
    Log.i("activity-demo", block().toString())
}