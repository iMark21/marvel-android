package com.imark.marvel.domain

import com.imark.marvel.data.MarvelRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: MarvelRepository
) {
    suspend operator fun invoke() = repository.getCharacters()
}