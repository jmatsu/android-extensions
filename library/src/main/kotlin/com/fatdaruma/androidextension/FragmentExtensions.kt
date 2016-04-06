/**
 * Copyright 2016 Jumpei Matsuda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:JvmName("FragmentUtils")

package com.fatdaruma.androidextension

import android.app.DialogFragment
import android.app.Fragment
import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.StringRes
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.app.DialogFragment as SupportDialogFragment
import android.support.v4.app.Fragment as SupportFragment

fun Fragment.getString(@StringRes resId: Int): String = resources.getString(resId)
fun SupportFragment.getString(@StringRes resId: Int): String = resources.getString(resId)

fun Fragment.getString(@StringRes resId: Int, vararg args: Any): String = resources.getString(resId, *args)
fun SupportFragment.getString(@StringRes resId: Int, vararg args: Any): String = resources.getString(resId, *args)

fun Fragment.getColor(@ColorRes resId: Int): Int = ContextCompat.getColor(context, resId)
fun SupportFragment.getColor(@ColorRes resId: Int): Int = ContextCompat.getColor(context, resId)

fun Fragment.getDimensionPixelSize(@DimenRes resId: Int): Int = resources.getDimensionPixelSize(resId)
fun SupportFragment.getDimensionPixelSize(@DimenRes resId: Int): Int = resources.getDimensionPixelSize(resId)

fun SupportFragment.invalidateOptionsMenu() {
    activity ?: return
    ActivityCompat.invalidateOptionsMenu(activity)
}

inline fun <reified T> T.showDialog(dialog: DialogFragment) where T : Fragment {
    dialog.show(fragmentManager, dialog.javaClass.simpleName)
}

inline fun <reified T> T.showDialog(dialog: SupportDialogFragment) where T : SupportFragment {
    dialog.show(childFragmentManager, dialog.javaClass.simpleName)
}

inline fun <reified T> T.initArguments(f: Bundle.() -> Unit) : T where T : Fragment = apply {
    arguments = Bundle().apply(f)
}

inline fun <reified T> T.initArguments(f: Bundle.() -> Unit) : T where T : SupportFragment = apply {
    arguments = Bundle().apply(f)
}

inline fun <reified T> Fragment.bindArgs(key: String, noinline converter: ((Any) -> T) = { it as T }): Lazy<T> = lazy { getArgs(this, key, converter) }
inline fun <reified T> android.support.v4.app.Fragment.bindArgs(key: String, noinline converter: ((Any) -> T) = { it as T }): Lazy<T> = lazy { getArgs(this, key, converter) }

inline fun <reified T : Any?> getArgs(thisRef: Any, key: String, noinline converter: ((Any) -> T)): T = run {
    converter(when (thisRef) {
        is Fragment -> {
            thisRef.arguments[key] ?: throw IllegalArgumentException("Arguments must have key - $key")
        }
        is SupportFragment -> {
            thisRef.arguments[key] ?: throw IllegalArgumentException("Arguments must have key - $key")
        }
        else -> throw IllegalStateException("Only allowed Fragment and SupportFragment")
    })
}