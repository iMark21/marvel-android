package com.imark.marvel.data.model

data class CharactersListResponse(
    val code: Int,
    val data: CharactersResponse
)

data class CharactersResponse(
    val results: List<Character>,
    val offset: Int,
    val count: Int,
    val total: Int,
    val limit: Int
)

data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail
)

data class Thumbnail(
    val path: String,
    val extension: String,
) {
    fun getURL(): String {
        return "${this.path}.${this.extension}"
    }
}