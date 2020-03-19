package com.example.anagram.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anagram.R
import com.example.anagram.data.AnagramListItem
import com.example.anagram.viewholder.AngramMatchViewHolder
import com.example.anagram.viewholder.AngramViewHolder


class AnagramListAdapter(val context:Context, val anagramList:List<AnagramListItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_Angram_Matched = 1
    private val TYPE_Angram = 2



    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int):RecyclerView.ViewHolder {
        val view:View;
        println("onCreateViewHolder ${anagramList.size}")
        if (viewType == TYPE_Angram_Matched) { // for call layout
            view = LayoutInflater.from(context).inflate(R.layout.angram_item_match, viewGroup, false);
            return AngramMatchViewHolder(view);

        } else { // for email layout
            view = LayoutInflater.from(context).inflate(R.layout.angram_item, viewGroup, false);
            return  AngramViewHolder(view);
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (anagramList.get(position).isMatched) {
            TYPE_Angram_Matched
        } else {
            TYPE_Angram
        }
    }
    override fun getItemCount(): Int {
        return anagramList.size

    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        println("onBindViewHolder ${anagramList.size}")
        if (getItemViewType(position) === TYPE_Angram_Matched) {
            (viewHolder as AngramMatchViewHolder).setAngramMatchDetails(anagramList.get(position))
        } else {
            (viewHolder as AngramViewHolder).setAngramDetails(anagramList.get(position))
        }
    }


}