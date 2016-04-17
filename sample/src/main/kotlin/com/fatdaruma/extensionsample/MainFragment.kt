package com.fatdaruma.extensionsample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.fatdaruma.androidextension.*

class MainFragment : Fragment() {
    companion object {
        fun newInstance(): MainFragment = MainFragment().initArguments {
            this[Keys.primitiveValue] = 10
            this[Keys.objectiveValue] = "objectiveValue"
            this[Keys.resource] = R.string.app_name
        }
    }

    private object Keys {
        const val primitiveValue = "primitiveValue"
        const val objectiveValue = "objectiveValue"
        const val resource = "resource"
    }

    private val primitiveValue: Int by bindArgs(Keys.primitiveValue)
    private val objectiveValue: String by bindArgs(Keys.objectiveValue)
    private val resource: String by bindResourceString(Keys.resource)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main, container, false).apply {
            var textView: TextView = findById(R.id.first_text)
            textView.text = primitiveValue.toString()

            textView = findById(R.id.second_text)
            textView.text = objectiveValue

            textView = findById(R.id.third_text)
            textView.text = resource
        }
    }
}