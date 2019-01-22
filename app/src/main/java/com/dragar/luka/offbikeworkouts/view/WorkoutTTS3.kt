/*
 * This file is part of Feeel.
 *
 *     Feeel is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Feeel is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Feeel.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.dragar.luka.offbikeworkouts.view

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.speech.tts.TextToSpeech
import android.support.annotation.RequiresApi
import android.util.Log
import com.dragar.luka.offbikeworkouts.R
import com.dragar.luka.offbikeworkouts.WorkoutContract3
import com.dragar.luka.offbikeworkouts.model.ExerciseMeta3
import java.lang.ref.WeakReference

/**
@author Miroslav Mazel
 */
class WorkoutTTS3(private val context: WeakReference<Context>) : WorkoutContract3.View, TextToSpeech.OnInitListener {
    private val countdown = 5
    private val halftimeMin = 8
    private val tts = TextToSpeech(context.get(), this)

    private var halfTime = 0
    private var ttsLoaded = false

    override fun close() { //todo test for this
        tts.shutdown()
    }

    //
    // TextToSpeech.OnInitListener
    //
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val languageSet =
                    if (Build.VERSION.SDK_INT >= 24)
                        setLanguageAPI24(tts)
                    else
                        setLanguageAPI15(tts)
            if (!languageSet) Log.e("TTS", "No system languages supported")
            ttsLoaded = true
        } else Log.e("TTS", "Init failed")
    }

    //
    // Speech
    //

    private fun speak(string: String?) {
        if (ttsLoaded && string != null) {
            val pronouncableString = string.toLowerCase() //avoids e.g. "Ab" being read as "A flat"
            if (Build.VERSION.SDK_INT >= 21)
                speakAPI21(pronouncableString)
            else
                speakAPI15(pronouncableString)
        }
    }

    @RequiresApi(api = 21)
    private fun speakAPI21(string: String) {
        tts.speak(string, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    @Suppress("DEPRECATION")
    @TargetApi(15)
    private fun speakAPI15(string: String) {
        tts.speak(string, TextToSpeech.QUEUE_FLUSH, null)
    }

    @RequiresApi(api = 24)
    private fun setLanguageAPI24(tts: TextToSpeech): Boolean {
        val locales = context.get()?.resources?.configuration?.locales
        for (i in 0 until (locales?.size() ?: 0)) {
            val result = tts.setLanguage(locales?.get(i))
            if (result == TextToSpeech.LANG_AVAILABLE) {
                return true
            }
        }
        return false
    }

    @Suppress("DEPRECATION")
    @TargetApi(15)
    private fun setLanguageAPI15(tts: TextToSpeech): Boolean {
        val result = tts.setLanguage(context.get()?.resources?.configuration?.locale)
        if (result == TextToSpeech.LANG_AVAILABLE)
            return true
        return false
    }

    //
    // WorkoutContract.View
    //

    override fun setExercise(workoutPos: Int, exerciseMeta: ExerciseMeta3) {
        halfTime = exerciseMeta.duration / 2

        speak(context.get()?.getString(exerciseMeta.exercise.titleResource))
    }

    override fun setBreak(workoutPos: Int, nextExerciseMeta: ExerciseMeta3, breakLength: Int) {
        val nextString = context.get()?.getString(nextExerciseMeta.exercise.titleResource)

        speak(context.get()?.getString(R.string.audio_break) +
                String.format(
                        context.get()?.getString(R.string.next_label) ?: "",
                        nextString)
        )
    }

    override fun showFinish() {
        speak(context.get()?.getString(R.string.audio_done))
    }

    override fun setSeconds(seconds: Int) {
        if (seconds <= countdown)
            speak(seconds.toString())

        if (!tts.isSpeaking) {
            if (seconds == halfTime && halfTime >= halftimeMin) {
                speak(String.format(context.get()?.getString(R.string.audio_halftime) ?: "", seconds))
            }
        }
    }

    override fun setPlaying() {}

    override fun setPaused() {}
}