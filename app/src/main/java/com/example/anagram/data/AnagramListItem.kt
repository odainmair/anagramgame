package com.example.anagram.data

data class AnagramListItem (
    val lineNoFirstFile:Int,
    val wordFirstFile:String,
    val lineNoSecondFile:Int,
    val wordSecondFile:String,
    val isMatched:Boolean
){
    fun getAngramItemDesc ():String{
        if(isMatched) {
            return "First File Line No. ${lineNoFirstFile+1} ${wordFirstFile} is the same as Second File Line No.${lineNoSecondFile+1} ${wordSecondFile} "
        }else{
            return "First File Line No. ${lineNoFirstFile+1} ${wordFirstFile} angram with Second File Line No.${lineNoSecondFile+1} ${wordSecondFile} "
        }
    }
    companion object {
        fun empty() = AnagramListItem(0, "",
            0, "", false)
    }
}