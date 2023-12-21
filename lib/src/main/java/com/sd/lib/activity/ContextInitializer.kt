package com.sd.lib.activity

import android.content.Context
import androidx.startup.Initializer

internal class ContextInitializer : Initializer<Context> {
    override fun create(context: Context): Context {
        FLastActivity.init(context)
        return context
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}