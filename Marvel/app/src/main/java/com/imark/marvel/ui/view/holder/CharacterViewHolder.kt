package com.imark.marvel.ui.view.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.imark.marvel.data.model.Character
import com.imark.marvel.databinding.ItemCharacterBinding
import com.squareup.picasso.Picasso

class CharacterViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val binding = ItemCharacterBinding.bind(view)

    fun bind(character: Character) {
        Picasso.get().load(
            character.thumbnail.getURL()
        ).into(binding.ivCharacter)
    }
}