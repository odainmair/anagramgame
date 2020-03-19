package com.example.anagram.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.anagram.data.AnagramListItem
import com.example.anagram.data.FileListItem

class AngramViewModel: ViewModel() {

    private  val  angramList = ArrayList<FileListItem>()
    val  canStartGame=MutableLiveData<Boolean>(false)
    val  isGameFinshed=MutableLiveData<Boolean>(false)
    var  angramListLiveData=MutableLiveData<List<AnagramListItem>>()
    val fileListLiveData=MutableLiveData<List<FileListItem>>()

    private var fileCount:Int =0

    fun getMatchedWord():String{
        val sb = StringBuilder()
        angramListLiveData.value?.map { it-> if(it.isMatched)sb.append("${it.wordFirstFile}\n")}
        return sb.toString()
    }
    fun addNewFileListItem(wordList:List<String>){

        ++fileCount
        angramList.add(FileListItem("Anagram ${fileCount}",wordList))

        fileListLiveData.value =angramList
        if(angramList.size==2){
            canStartGame.value=true;
        }

    }
    fun areAnagram(str1: CharArray, str2: CharArray): Boolean {
        // Get lenghts of both strings
        val n1 = str1.size
        val n2 = str2.size


        if (n1 != n2)
            return false;

        // Sort both strings
        str1.sort()
        str2.sort()
        // Compare sorted strings
        return str1.contentEquals(str2);
    }

    fun startGame() {
        println("In game ")
        val firstAngramList: List<String>? = angramList.get(0).wordList
        val secondAngramList: List<String>? = angramList.get(1).wordList
        val angramList = ArrayList<AnagramListItem>()
        if (firstAngramList != null) {
            for ((firstIndex, firstWord) in firstAngramList.withIndex()) {
                if (secondAngramList != null) {
                    for ((secondIndex, secondWord) in secondAngramList.withIndex()) {
                        if (firstWord.equals(secondWord)){
                            angramList.add(AnagramListItem(firstIndex+1,firstWord,secondIndex+1,secondWord,true))
                            angramListLiveData.value =angramList
                            println("First File Line No. ${firstIndex} ${firstWord} is the same as Line No.${secondIndex} ${secondWord} ")

                        }
                        else if (areAnagram(firstWord.toCharArray(),secondWord.toCharArray())){
                            angramList.add(AnagramListItem(firstIndex+1,firstWord,secondIndex+1,secondWord,false))
                            angramListLiveData.value =angramList
                            println("First File Line No. ${firstIndex} ${firstWord} angram with Second File Line No.${secondIndex} ${secondWord} ")
                        }
                    }
                }
            }
        }
        println("End Game")
        isGameFinshed.value=true
    }
}