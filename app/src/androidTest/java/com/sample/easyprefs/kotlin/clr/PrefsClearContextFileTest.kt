package com.sample.easyprefs.kotlin.clr

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.sample.easyprefs.kotlin.Const
import io.easyprefs.Prefs
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PrefsClearContextFileTest {

    private lateinit var context: Context

    @Before
    fun initApp() {
        //Prefs.initializeApp()
        context = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun test1_ClearCommitOp() {
        assertTrue(Prefs.clear(context, Const.PREF_SAMPLE_FILE).all().commit())

        val data = Prefs.read(context, Const.PREF_SAMPLE_FILE).content(Const.SAMPLE_STRING_KEY, "")
        assertEquals("", data)
    }

    @Test
    fun test2_ClearApplyOp() {
        Prefs.clear(context, Const.PREF_SAMPLE_FILE).all().apply()

        val data = Prefs.read(context,
            Const.PREF_SAMPLE_FILE
        ).content(Const.SAMPLE_STRING_KEY_APPLY, "")
        assertEquals("", data)
    }
}