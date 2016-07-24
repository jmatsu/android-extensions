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
import android.os.Parcelable
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.StringRes
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty
import android.support.v4.app.DialogFragment as SupportDialogFragment
import android.support.v4.app.Fragment as SupportFragment

fun Fragment.getString(@StringRes resId: Int): String = resources.getString(resId)
fun SupportFragment.getString(@StringRes resId: Int): String = resources.getString(resId)

fun Fragment.getString(@StringRes resId: Int, vararg args: Any): String = resources.getString(resId, *args)
fun SupportFragment.getString(@StringRes resId: Int, vararg args: Any): String = resources.getString(resId, *args)

fun Fragment.getColor(@ColorRes resId: Int): Int = ContextCompat.getColor(activity, resId)
fun SupportFragment.getColor(@ColorRes resId: Int): Int = ContextCompat.getColor(context, resId)

fun Fragment.getDimensionPixelSize(@DimenRes resId: Int): Int = resources.getDimensionPixelSize(resId)
fun SupportFragment.getDimensionPixelSize(@DimenRes resId: Int): Int = resources.getDimensionPixelSize(resId)

fun SupportFragment.invalidateOptionsMenu() {
    val activity = activity ?: return
    ActivityCompat.invalidateOptionsMenu(activity)
}

fun Fragment.showDialog(dialog: DialogFragment) {
    dialog.show(fragmentManager, dialog.javaClass.name)
}

fun SupportFragment.showDialog(dialog: SupportDialogFragment) {
    dialog.show(childFragmentManager, dialog.javaClass.name)
}

fun <T> T.initArguments(f: Bundle.() -> Unit): T where T : Fragment = apply {
    arguments = Bundle().apply(f)
}

fun <T> T.initArguments(f: Bundle.() -> Unit): T where T : SupportFragment = apply {
    arguments = Bundle().apply(f)
}


fun <T : Any> Fragment.bindArgs(key: String, transformer: ((Any) -> T) = { it as T }): ReadWriteProperty<Fragment, T> = CacheProperty(key, transformer)
fun <T : Any> SupportFragment.bindArgs(key: String, transformer: ((Any) -> T) = { it as T }): ReadWriteProperty<SupportFragment, T> = CacheProperty(key, transformer)

fun <T : Any> Fragment.bindArgsWithOptionKey(key: String, transformer: ((Any) -> T) = { it as T }): ReadWriteProperty<Fragment, T?> = OptionalValueCacheProperty(key, transformer)
fun <T : Any> SupportFragment.bindArgsWithOptionKey(key: String, transformer: ((Any) -> T) = { it as T }): ReadWriteProperty<SupportFragment, T?> = OptionalValueCacheProperty(key, transformer)

fun <T : Any> Fragment.bindArgs(key: String, initialValue: T, transformer: ((Any) -> T) = { it as T }): ReadWriteProperty<Fragment, T> = InitialValueCacheProperty(key, initialValue, transformer)
fun <T : Any> SupportFragment.bindArgs(key: String, initialValue: T, transformer: ((Any) -> T) = { it as T }): ReadWriteProperty<SupportFragment, T> = InitialValueCacheProperty(key, initialValue, transformer)


fun Fragment.bindString(key: String): ReadWriteProperty<Fragment, String> = bindArgs(key)
fun SupportFragment.bindString(key: String): ReadWriteProperty<SupportFragment, String> = bindArgs(key)

fun Fragment.bindBoolean(key: String): ReadWriteProperty<Fragment, Boolean> = bindArgs(key)
fun SupportFragment.bindBoolean(key: String): ReadWriteProperty<SupportFragment, Boolean> = bindArgs(key)

fun Fragment.bindInt(key: String): ReadWriteProperty<Fragment, Int> = bindArgs(key)
fun SupportFragment.bindInt(key: String): ReadWriteProperty<SupportFragment, Int> = bindArgs(key)

fun Fragment.bindLong(key: String): ReadWriteProperty<Fragment, Long> = bindArgs(key)
fun SupportFragment.bindLong(key: String): ReadWriteProperty<SupportFragment, Long> = bindArgs(key)

fun Fragment.bindDouble(key: String): ReadWriteProperty<Fragment, Double> = bindArgs(key)
fun SupportFragment.bindDouble(key: String): ReadWriteProperty<SupportFragment, Double> = bindArgs(key)

fun Fragment.bindFloat(key: String): ReadWriteProperty<Fragment, Float> = bindArgs(key)
fun SupportFragment.bindFloat(key: String): ReadWriteProperty<SupportFragment, Float> = bindArgs(key)

fun Fragment.bindByte(key: String): ReadWriteProperty<Fragment, Byte> = bindArgs(key)
fun SupportFragment.bindByte(key: String): ReadWriteProperty<SupportFragment, Byte> = bindArgs(key)

fun Fragment.bindShort(key: String): ReadWriteProperty<Fragment, Short> = bindArgs(key)
fun SupportFragment.bindShort(key: String): ReadWriteProperty<SupportFragment, Short> = bindArgs(key)

fun Fragment.bindChar(key: String): ReadWriteProperty<Fragment, Char> = bindArgs(key)
fun SupportFragment.bindChar(key: String): ReadWriteProperty<SupportFragment, Char> = bindArgs(key)

fun Fragment.bindCharSequence(key: String): ReadWriteProperty<Fragment, CharSequence> = bindArgs(key)
fun SupportFragment.bindCharSequence(key: String): ReadWriteProperty<SupportFragment, CharSequence> = bindArgs(key)

fun Fragment.bindBundle(key: String): ReadWriteProperty<Fragment, Bundle> = bindArgs(key)
fun SupportFragment.bindBundle(key: String): ReadWriteProperty<SupportFragment, Bundle> = bindArgs(key)

fun Fragment.bindParcelable(key: String): ReadWriteProperty<Fragment, Parcelable> = bindArgs(key)
fun SupportFragment.bindParcelable(key: String): ReadWriteProperty<SupportFragment, Parcelable> = bindArgs(key)

fun Fragment.bindResourceString(key: String): ReadWriteProperty<Fragment, String> = bindArgs(key) { getString(it as Int) }
fun SupportFragment.bindResourceString(key: String): ReadWriteProperty<SupportFragment, String> = bindArgs(key) { getString(it as Int) }

fun Fragment.bindResourceColor(key: String): ReadWriteProperty<Fragment, Int> = bindArgs(key) { getColor(it as Int) }
fun SupportFragment.bindResourceColor(key: String): ReadWriteProperty<SupportFragment, Int> = bindArgs(key) { getColor(it as Int) }

fun Fragment.bindResourceDimensionPixelSize(key: String): ReadWriteProperty<Fragment, Int> = bindArgs(key) { getDimensionPixelSize(it as Int) }
fun SupportFragment.bindResourceDimensionPixelSize(key: String): ReadWriteProperty<SupportFragment, Int> = bindArgs(key) { getDimensionPixelSize(it as Int) }


private class CacheProperty<T : Any, in R>(private val key: String, private val transformer: ((Any) -> T)) : ReadWriteProperty<R, T> {
    private var isFirst: Boolean = true
    private var cache: T by Delegates.notNull()

    override fun getValue(thisRef: R, property: KProperty<*>): T {
        if (isFirst) {
            when (thisRef) {
                is SupportFragment -> cache = transformer(thisRef.arguments[key] ?: throw IllegalArgumentException("Arguments must have key - $key"))
                is Fragment -> cache = transformer(thisRef.arguments[key] ?: throw IllegalArgumentException("Arguments must have key - $key"))
                else -> throw ClassCastException("$thisRef Cannot be allowed")
            }
        }

        isFirst = false

        return cache
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: T) {
        cache = value
        isFirst = false
    }
}

private class OptionalValueCacheProperty<T : Any, in R>(private val key: String, private val transformer: ((Any) -> T)) : ReadWriteProperty<R, T?> {
    private var isFirst: Boolean = true
    private var cache: T? = null

    override fun getValue(thisRef: R, property: KProperty<*>): T? {
        if (isFirst) {
            when (thisRef) {
                is SupportFragment -> cache = thisRef.arguments[key]?.let(transformer)
                is Fragment -> cache = thisRef.arguments[key]?.let(transformer)
                else -> throw ClassCastException("$thisRef Cannot be allowed")
            }
        }

        isFirst = false

        return cache
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: T?) {
        cache = value
        isFirst = false
    }
}

private class InitialValueCacheProperty<T : Any, in R>(private val key: String, initialValue: T, private val transformer: ((Any) -> T)) : ReadWriteProperty<R, T> {
    private var isFirst: Boolean = true
    private var cache: T = initialValue

    override fun getValue(thisRef: R, property: KProperty<*>): T {
        if (isFirst) {
            when (thisRef) {
                is SupportFragment -> thisRef.arguments[key]?.let(transformer)?.let { cache = it }
                is Fragment -> thisRef.arguments[key]?.let(transformer)?.let { cache = it }
                else -> throw ClassCastException("$thisRef Cannot be allowed")
            }
        }

        isFirst = false

        return cache
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: T) {
        cache = value
        isFirst = false
    }
}
