package com.example.anagram.util

import android.content.Context
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.anagram.R

class CommonUIUtils {

    companion object{
        fun markButtonDisable(context: Context, button: Button) {
            button?.isEnabled = false
            button?.setTextColor(
                ContextCompat.getColor(context,
                    R.color.white
                ))
            button?.setBackgroundColor(
                ContextCompat.getColor(context,
                    R.color.colorGray6
                ))
        }
        fun markButtonEnable(context: Context, button: Button) {
            button?.isEnabled = true
            button?.setTextColor(
                ContextCompat.getColor(context,
                    R.color.white
                ))
            button?.setBackgroundColor(
                ContextCompat.getColor(context,
                    R.color.colorPrimary
                ))
        }

    }
}
