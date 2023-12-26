package com.sd.lib.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import java.util.concurrent.atomic.AtomicBoolean

@SuppressLint("StaticFieldLeak")
object FLastActivity {
    private val _register = AtomicBoolean()
    private var _lastActivity: Activity? = null

    internal fun init(context: Context) {
        if (_register.compareAndSet(false, true)) {
            val application = context.applicationContext as Application
            application.registerActivityLifecycleCallbacks(_callback)
        }
    }

    @JvmStatic
    fun get(): Activity? = _lastActivity

    private val _callback = object : Application.ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            _lastActivity = activity
        }

        override fun onActivityStarted(activity: Activity) {
            _lastActivity = activity
        }

        override fun onActivityResumed(activity: Activity) {
            _lastActivity = activity
        }

        override fun onActivityPaused(activity: Activity) {
            if (_lastActivity === activity) {
                _lastActivity = null
            }
        }

        override fun onActivityStopped(activity: Activity) {}

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

        override fun onActivityDestroyed(activity: Activity) {}
    }
}

val fLastActivity: Activity? get() = FLastActivity.get()