@file:JvmName("ViewUtils")

package com.fatdaruma.androidextension

import android.view.View

inline fun <reified T> View.findById(id: Int): T where T : View = findViewById(id) as T
