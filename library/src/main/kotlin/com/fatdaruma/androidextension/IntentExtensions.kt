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

@file:JvmName("IntentUtils")

package com.fatdaruma.androidextension

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import java.util.*


operator fun Intent.contains(key: String) = hasExtra(key)

operator inline fun <reified T> Intent.get(key: String): T? = obtain(key)

inline fun <reified T> Intent.obtain(key: String, noinline converter: ((Any) -> T) = { it as T }): T? = extras?.obtain(key, converter)

operator inline fun <reified T> Intent.set(key: String, value: T) {
    when (value) {
        is Boolean -> putExtra(key, value)
        is Int -> putExtra(key, value)
        is Long -> putExtra(key, value)
        is Float -> putExtra(key, value)
        is Double -> putExtra(key, value)
        is Byte -> putExtra(key, value)
        is Short -> putExtra(key, value)
        is Char -> putExtra(key, value)
        is String -> putExtra(key, value)
        is CharSequence -> putExtra(key, value)
        is Bundle -> putExtra(key, value)
        is Parcelable -> putExtra(key, value)
        else -> throw IllegalArgumentException("Cannot accept the given value. -> $value")
    }
}

operator inline fun <reified T> Intent.set(key: String, value: Array<T>) {
    when (T::class) {
        Boolean::class -> putExtra(key, value.map { it as Boolean }.toBooleanArray())
        Int::class -> putExtra(key, value.map { it as Int }.toIntArray())
        Long::class -> putExtra(key, value.map { it as Long }.toLongArray())
        Float::class -> putExtra(key, value.map { it as Float }.toFloatArray())
        Double::class -> putExtra(key, value.map { it as Double }.toDoubleArray())
        Byte::class -> putExtra(key, value.map { it as Byte }.toByteArray())
        Short::class -> putExtra(key, value.map { it as Short }.toShortArray())
        Char::class -> putExtra(key, value.map { it as Char }.toCharArray())
        String::class -> putExtra(key, value.map { it as String }.toTypedArray())
        CharSequence::class -> putExtra(key, value.map { it as CharSequence }.toTypedArray())
        else -> throw IllegalArgumentException("Cannot accept the given value. -> $value")
    }
}

operator inline fun <reified T> Intent.set(key: String, value: ArrayList<T>) {
    when (T::class) {
        Int::class -> putExtra(key, ArrayList(value.map { it as Int }))
        String::class -> putExtra(key, ArrayList(value.map { it as String }))
        CharSequence::class -> putExtra(key, ArrayList(value.map { it as CharSequence }))
        else -> {
            if (value.first() is Parcelable) {
                putExtra(key, ArrayList(value.map { it as Parcelable }))
            } else {
                throw IllegalArgumentException("Cannot accept the given value. -> $value")
            }
        }
    }
}