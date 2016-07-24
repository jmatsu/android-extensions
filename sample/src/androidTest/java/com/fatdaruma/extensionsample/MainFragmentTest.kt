package com.fatdaruma.extensionsample

import android.support.test.espresso.Espresso
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.test.suitebuilder.annotation.LargeTest
import android.view.View
import android.widget.TextView
import com.fatdaruma.androidextension.findById
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.should.shouldMatch
import org.hamcrest.core.AllOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.properties.Delegates

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainFragmentTest {

    // or @JvmField @Rule
    @get:Rule
    var activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    private var activity: MainActivity by Delegates.notNull()

    @Before
    fun beforeEach() {
        activity = activityTestRule.activity
    }

    private inline fun <reified T> MainActivity.findViewInMainFragment(id: Int): T where T : View {
        return (supportFragmentManager.fragments.first() as MainFragment).view!!.findById(id)
    }

    private fun textMatch(id: Int, assertions: (String) -> Unit) {
        val textView: TextView = activity.findViewInMainFragment(id)
        assertions(textView.text.toString())
    }

    @Test
    fun checkAll() {
        textMatch(R.id.first_text) {
            it shouldMatch equalTo(MainFragment.First.toString())
        }
        textMatch(R.id.second_text) {
            it shouldMatch equalTo(MainFragment.Second.toString())
        }
        textMatch(R.id.third_text) {
            it shouldMatch equalTo(activity.getString(MainFragment.Third))
        }
        textMatch(R.id.fourth_text) {
            it shouldMatch equalTo(MainFragment.Fourth.toString())
        }
        textMatch(R.id.fifth_text) {
            it shouldMatch equalTo(MainFragment.Fifth.toString())
        }

        // don't crash on runtime
        Espresso.onView(AllOf.allOf(ViewMatchers.withId(android.R.id.content), ViewMatchers.isDisplayed()))

        Thread.sleep(2000)
    }
}