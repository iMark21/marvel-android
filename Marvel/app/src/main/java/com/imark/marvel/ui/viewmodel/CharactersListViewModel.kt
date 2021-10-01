package com.imark.marvel.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imark.marvel.data.model.Character
import com.imark.marvel.domain.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersListViewModel @Inject constructor(
    private val getCharactersUseCase:GetCharactersUseCase
): ViewModel() {

    val characters = MutableLiveData<List<Character>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getCharactersUseCase()
            characters.postValue(result)
            isLoading.postValue(false)
        }
    }
}