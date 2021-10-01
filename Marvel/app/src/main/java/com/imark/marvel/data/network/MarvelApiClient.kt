package com.imark.marvel.data.network

import com.imark.marvel.data.model.CharactersListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MarvelApiClient {
    @GET("v1/public/characters")
    suspend fun getCharacters(
        @QueryMap filter: Map<String, String>
    ):Response<CharactersListResponse>
}