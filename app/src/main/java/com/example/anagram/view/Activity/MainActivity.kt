package com.example.anagram.view.Activity

import android.app.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anagram.R
import com.example.anagram.data.AnagramListItem
import com.example.anagram.data.FileListItem
import com.example.anagram.util.CommonUIUtils
import com.example.anagram.util.FileUtil
import com.example.anagram.util.PustNotificationUtil
import com.example.anagram.util.SendEmailUtils
import com.example.anagram.view.adapter.AnagramListAdapter
import com.example.anagram.view.adapter.FileListAdapter
import com.example.anagram.viewmodel.AngramViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val OPEN_REQUEST_CODE = 41
    private val angramViewModel: AngramViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shareBtn.isEnabled = false
        val angramListRecyclerView : RecyclerView = findViewById(R.id.angramListRecyclerView)
        angramListRecyclerView.layoutManager = LinearLayoutManager(this , RecyclerView.VERTICAL, false)
        val fileListRecyclerView : RecyclerView = findViewById(R.id.fileListRecyclerView)
        fileListRecyclerView.layoutManager = LinearLayoutManager(this , RecyclerView.VERTICAL, false)

        val chooseFileListener = View.OnClickListener { v ->
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "text/plain"
            startActivityForResult(intent, OPEN_REQUEST_CODE)
        }
        addFileBtn.setOnClickListener(chooseFileListener)

        startGameBtn.setOnClickListener {
            angramViewModel.startGame()
        }
        shareBtn.setOnClickListener {view ->
            val anagramMatchedWordList= angramViewModel.getMatchedWord()
            SendEmailUtils.sendEmail(this,arrayOf("m.abumazkoor.ncbs@mobily.com.sa"),"Anagram Game","ANAGRAM matched words: \n $anagramMatchedWordList")

        }

        angramViewModel.canStartGame.observe(this, Observer<Boolean> { handleStartGameButton(it) })
        angramViewModel.isGameFinshed.observe(this, Observer<Boolean> { handleWhenGameFinshed(it) })
        angramViewModel.angramListLiveData.observe(this, Observer<List<AnagramListItem>> {
           handleAngramList(it,angramListRecyclerView)
        })
        angramViewModel.fileListLiveData.observe(this, Observer<List<FileListItem>> {
            handleFileList(it,fileListRecyclerView)
        })
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int,
                                         resultData: Intent?) {
        super.onActivityResult(requestCode, resultCode, resultData)
        var currentUri: Uri? = null
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == OPEN_REQUEST_CODE) {
                resultData?.clipData
                resultData?.let {
                    currentUri = it.data
                    angramViewModel.addNewFileListItem(FileUtil.convertFileContentToList(currentUri,contentResolver))

                }
            }
        }
    }
      private fun handleStartGameButton (flag:Boolean){
          if (flag){
              Toast.makeText(getApplicationContext(),"You Can Start GAME Now",Toast.LENGTH_SHORT).show();
              addFileBtn.isEnabled=false
              startGameBtn.isEnabled=true
          }else{
              startGameBtn.isEnabled=false

          }
      }
      private fun handleWhenGameFinshed (flag:Boolean){
          if(flag){
             Toast.makeText(getApplicationContext(),"Finally The GAME END, You can share Result with your friend",Toast.LENGTH_LONG).show();
              shareBtn.isEnabled = true
          }
       }

    private fun handleAngramList (anagramList:List<AnagramListItem>,recyclerView:RecyclerView){
        PustNotificationUtil.sendNotification(this,"ANGRAM GAME","anagram found!, total anagram count ${anagramList.size}",Intent(this,
            MainActivity::class.java))
       // println("in handleAngramList ${anagramListItem.size}")
        //Toast.makeText(getApplicationContext(),"ANAGRAM FOUND!, TOTAL ANAGRAM COUNT ${anagramList.size}",Toast.LENGTH_LONG).show();
        anagramFoundTxtView.text="Total Anagram Count (${anagramList.size})"
        val adapter = AnagramListAdapter(this,anagramList)
        recyclerView.adapter = adapter

    }

    private fun handleFileList (fileList:List<FileListItem>,recyclerView:RecyclerView){
        anagramFileTxtView.text="Anagram Files (${fileList.size})"
        val adapter = FileListAdapter(fileList)
        recyclerView.adapter = adapter
    }

}

