package com.example.roomwordsample_googlecodelap.presentation

import androidx.lifecycle.*
import com.example.roomwordsample_googlecodelap.data.Word
import com.example.roomwordsample_googlecodelap.repo.WordRepository
import com.example.roomwordsample_googlecodelap.repo.wordRepository
import kotlinx.coroutines.launch

class viewModel(private val repository: wordRepository) : ViewModel() {


    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()


    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}

class WordViewModelFactory(private val repository: wordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return viewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

