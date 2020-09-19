package com.medialink.myretrofitarch.ui.character

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.medialink.myretrofitarch.data.repository.CharacterRepository

class CharactersViewModel
@ViewModelInject constructor(
    private val repository: CharacterRepository
): ViewModel() {
    val characters = repository.getCharacters()
}