package com.example.anagram.viewholder


import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.anagram.data.AnagramListItem
import com.example.anagram.R

class AngramMatchViewHolder(itemView: View) : ViewHolder(itemView) {
    private val angramDesc: TextView

    fun setAngramMatchDetails(anagramListItem: AnagramListItem) {

        angramDesc.setText(anagramListItem.getAngramItemDesc())

    }

    init {
        angramDesc = itemView.findViewById(R.id.fileNameTextView)

    }
}