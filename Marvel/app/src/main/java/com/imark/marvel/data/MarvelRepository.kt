package com.imark.marvel.data

import com.imark.marvel.data.model.Character
import com.imark.marvel.data.network.MarvelService
import javax.inject.Inject

class MarvelRepository @Inject constructor(
    private val api: MarvelService
) {

    suspend fun getCharacters(): List<Character> {
        return api.getCharacters()
    }
}