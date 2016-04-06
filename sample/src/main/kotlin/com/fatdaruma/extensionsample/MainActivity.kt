package com.fatdaruma.extensionsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState ?: apply {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.container, MainFragment.newInstance())
            }.commit()
        }
    }
}