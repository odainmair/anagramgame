package com.example.anagram.viewholder


import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.anagram.data.AnagramListItem
import com.example.anagram.R
import com.example.anagram.viewmodel.AngramViewModel

class AngramViewHolder(itemView: View) : ViewHolder(itemView) {
    private val angramDesc: TextView

    fun setAngramDetails(anagramListItem: AnagramListItem) {
        angramDesc.setText(anagramListItem.getAngramItemDesc())

    }
    init {
        angramDesc = itemView.findViewById(R.id.fileNameTextView)

    }
}