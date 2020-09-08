package com.sample.easyprefs.kotlin.remove

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.sample.easyprefs.kotlin.Const
import io.easyprefs.Prefs
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class PrefsRemoveTest {

    @Before
    fun initApp() {
        Prefs.initializeApp(InstrumentationRegistry.getInstrumentation().targetContext)
    }

    @Test
    fun testClearCommitOp() {
        assertTrue(Prefs.remove().key(Const.SAMPLE_STRING_KEY).commit())

        val data = Prefs.read().content(Const.SAMPLE_STRING_KEY, "")
        assertEquals("", data)
    }

    @Test
    fun testClearApplyOp() {
        Prefs.remove().key(Const.SAMPLE_STRING_KEY_APPLY).apply()

        val data = Prefs.read().content(Const.SAMPLE_STRING_KEY_APPLY, "")
        assertEquals("", data)
    }
}