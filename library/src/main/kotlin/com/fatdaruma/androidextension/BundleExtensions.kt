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

@file:JvmName("BundleUtils")

package com.fatdaruma.androidextension

import android.os.Bundle
import android.os.IBinder
import android.os.Parcelable
import android.support.v4.app.BundleCompat
import android.util.Size
import android.util.SizeF
import java.util.*

operator fun Bundle.contains(key: String) = containsKey(key)

inline fun <reified R> Bundle.obtain(key: String, noinline converter: ((Any) -> R) = { it as R }): R = converter(this[key])

operator inline fun <reified T> Bundle.set(key: String, value: T) {
    when (value) {
        is Boolean -> putBoolean(key, value)
        is Int -> putInt(key, value)
        is Long -> putLong(key, value)
        is Float -> putFloat(key, value)
        is Double -> putDouble(key, value)
        is Byte -> putByte(key, value)
        is Short -> putShort(key, value)
        is Char -> putChar(key, value)
        is String -> putString(key, value)
        is CharSequence -> putCharSequence(key, value)
        is Bundle -> putBundle(key, value)
        is Parcelable -> putParcelable(key, value)
        is IBinder -> BundleCompat.putBinder(this, key, value)
        is Size -> putSize(key, value)
        is SizeF -> putSizeF(key, value)
        else -> throw IllegalArgumentException("Cannot accept the given value. -> $value")
    }
}

operator inline fun <reified T> Bundle.set(key: String, value: Array<T>) {
    when (T::class) {
        Boolean::class -> value.map { it as Boolean }.toBooleanArray()
        Int::class -> value.map { it as Int }.toIntArray()
        Long::class -> value.map { it as Long }.toLongArray()
        Float::class -> value.map { it as Float }.toFloatArray()
        Double::class -> value.map { it as Double }.toDoubleArray()
        Byte::class -> value.map { it as Byte }.toByteArray()
        Short::class -> value.map { it as Short }.toShortArray()
        Char::class -> value.map { it as Char }.toCharArray()
        String::class -> putStringArray(key, value.map { it as String }.toTypedArray())
        CharSequence::class -> putCharSequenceArray(key, value.map { it as CharSequence }.toTypedArray())
        else -> throw IllegalArgumentException("Cannot accept the given value. -> $value")
    }
}

operator inline fun <reified T> Bundle.set(key: String, value: ArrayList<T>) {
    when (T::class) {
        Int::class -> putIntegerArrayList(key, ArrayList(value.map { it as Int }))
        String::class -> putStringArrayList(key, ArrayList(value.map { it as String }))
        CharSequence::class -> putCharSequenceArrayList(key, ArrayList(value.map { it as CharSequence }))
        else -> {
            if (value.first() is Parcelable) {
                putParcelableArrayList(key, ArrayList(value.map { it as Parcelable }))
            } else {
                throw IllegalArgumentException("Cannot accept the given value. -> $value")
            }
        }
    }
}