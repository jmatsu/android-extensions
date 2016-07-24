@file:JvmName("IntentUtils")

package com.fatdaruma.androidextension

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import java.util.*


operator fun Intent.contains(key: String): Boolean = hasExtra(key)


operator inline fun <reified T> Intent.get(key: String): T? = obtain(key)


inline fun <reified T> Intent.obtain(key: String, noinline converter: ((Any) -> T?) = { it as? T }): T? = extras?.obtain(key, converter)


operator fun Intent.set(key: String, value: Boolean): Boolean =
        value.apply { putExtra(key, value) }

operator fun Intent.set(key: String, value: Int): Int =
        value.apply { putExtra(key, value) }

operator fun Intent.set(key: String, value: Long): Long =
        value.apply { putExtra(key, value) }

operator fun Intent.set(key: String, value: Float): Float =
        value.apply { putExtra(key, value) }

operator fun Intent.set(key: String, value: Double): Double
        = value.apply { putExtra(key, value) }

operator fun Intent.set(key: String, value: Byte): Byte =
        value.apply { putExtra(key, value) }

operator fun Intent.set(key: String, value: Short): Short =
        value.apply { putExtra(key, value) }

operator fun Intent.set(key: String, value: Char): Char =
        value.apply { putExtra(key, value) }

operator fun Intent.set(key: String, value: String): String =
        value.apply { putExtra(key, value) }

operator fun Intent.set(key: String, value: CharSequence): CharSequence =
        value.apply { putExtra(key, value) }

operator fun Intent.set(key: String, value: Bundle): Bundle =
        value.apply { putExtra(key, value) }

operator fun Intent.set(key: String, value: Parcelable): Parcelable =
        value.apply { putExtra(key, value) }


operator fun Intent.set(key: String, value: Array<Boolean>): Array<Boolean> =
        value.apply { putExtra(key, value.toBooleanArray()) }

operator fun Intent.set(key: String, value: Array<Int>): Array<Int> =
        value.apply { putExtra(key, value.toIntArray()) }

operator fun Intent.set(key: String, value: Array<Long>): Array<Long> =
        value.apply { putExtra(key, value.toLongArray()) }

operator fun Intent.set(key: String, value: Array<Float>): Array<Float> =
        value.apply { putExtra(key, value.toFloatArray()) }

operator fun Intent.set(key: String, value: Array<Double>): Array<Double> =
        value.apply { putExtra(key, value.toDoubleArray()) }

operator fun Intent.set(key: String, value: Array<Byte>): Array<Byte> =
        value.apply { putExtra(key, value.toByteArray()) }

operator fun Intent.set(key: String, value: Array<Short>): Array<Short> =
        value.apply { putExtra(key, value.toShortArray()) }

operator fun Intent.set(key: String, value: Array<Char>): Array<Char> =
        value.apply { putExtra(key, value.toCharArray()) }

operator fun Intent.set(key: String, value: Array<String>): Array<String> =
        value.apply { putExtra(key, value) }

operator fun Intent.set(key: String, value: Array<CharSequence>): Array<CharSequence> =
        value.apply { putExtra(key, value) }


@JvmName("putIntegerArrayList")
operator fun Intent.set(key: String, value: ArrayList<Int>): ArrayList<Int> =
        value.apply { putExtra(key, value) }

@JvmName("putStringArrayList")
operator fun Intent.set(key: String, value: ArrayList<String>): ArrayList<String> =
        value.apply { putExtra(key, value) }

@JvmName("putCharSequenceArrayList")
operator fun Intent.set(key: String, value: ArrayList<CharSequence>): ArrayList<CharSequence> =
        value.apply { putExtra(key, value) }

@JvmName("putParcelableArrayList")
operator fun Intent.set(key: String, value: ArrayList<Parcelable>): ArrayList<Parcelable> =
        value.apply { putExtra(key, value) }
