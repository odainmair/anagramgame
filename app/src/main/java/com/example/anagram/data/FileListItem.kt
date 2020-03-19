package com.example.anagram.data

data class FileListItem(val fileName:String,val wordList:List<String>) {
    fun getNumberOfWord():String {
        return "Number Of Words :${wordList.size}"
    }
}