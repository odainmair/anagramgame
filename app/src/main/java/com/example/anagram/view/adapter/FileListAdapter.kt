package com.example.anagram.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anagram.R
import com.example.anagram.data.FileListItem
import java.text.FieldPosition


class FileListAdapter(val fileList: List<FileListItem>) :
    RecyclerView.Adapter<FileListAdapter.ViewHolder>() {

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val fileListItem: FileListItem = fileList[position]

        viewHolder?.fileNameTextView?.text = fileListItem.fileName
        viewHolder?.numberOfWordsTextView?.text = fileListItem.getNumberOfWord()
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup?.context).inflate(R.layout.file_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return fileList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fileNameTextView: TextView = itemView.findViewById(R.id.fileNameTextView)
        val numberOfWordsTextView: TextView = itemView.findViewById(R.id.numberOfWordsTextView)

    }


}