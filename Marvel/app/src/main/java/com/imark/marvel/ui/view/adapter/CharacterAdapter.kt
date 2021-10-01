package com.imark.marvel.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imark.marvel.R
import com.imark.marvel.data.model.Character
import com.imark.marvel.ui.view.holder.CharacterViewHolder

class CharacterAdapter(private val characters: List<Character>): RecyclerView.Adapter<CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(
            layoutInflater.inflate(
                R.layout.item_character,
                parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        var item = characters[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = characters.size

}