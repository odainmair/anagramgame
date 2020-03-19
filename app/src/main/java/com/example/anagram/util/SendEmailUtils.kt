package com.example.anagram.util

import android.content.Context
import android.content.Intent


class SendEmailUtils {

    companion object{

        fun sendEmail(context: Context,to:Array<String>,subject:String,body:String){
            var emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.setType("plain/text")
            emailIntent.putExtra(Intent.EXTRA_EMAIL,to)
            emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject)
            emailIntent.putExtra(Intent.EXTRA_TEXT,body)
            context.startActivity(emailIntent)
        }
    }
}