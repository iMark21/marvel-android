package com.imark.marvel.data.network

import com.imark.marvel.core.Constants
import com.imark.marvel.data.model.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MarvelService @Inject constructor(private val api: MarvelApiClient) {

    suspend fun getCharacters(): List<Character> {
        return withContext(Dispatchers.IO) {
            val filter = mutableMapOf<String, String>()
            filter["ts"] = Constants.ts
            filter["apikey"] = Constants.API_KEY
            filter["hash"] = Constants.hash()
            api.getCharacters(filter).body()?.data?.results ?: emptyList()
        }
    }
}