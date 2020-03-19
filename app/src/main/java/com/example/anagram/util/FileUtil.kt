package com.example.anagram.util

import android.content.ContentResolver
import android.net.Uri
import java.io.BufferedReader
import java.io.InputStreamReader

class FileUtil {
    companion object {
        fun convertFileContentToList(uri: Uri?, contentResolver: ContentResolver): List<String> {
            val lineList = mutableListOf<String>()
            val inputStream = uri?.let { contentResolver.openInputStream(it) }
            val stringBuilder = StringBuilder()
            if (inputStream != null) {
                val reader = BufferedReader(
                    InputStreamReader(
                        inputStream
                    )
                )
                var currentline = reader.readLine()

                while (currentline != null) {
                    stringBuilder.append(currentline + "\n")
                    lineList.add(currentline)
                    currentline = reader.readLine()
                }

                inputStream.close()
            }
            return lineList;
        }
    }
}