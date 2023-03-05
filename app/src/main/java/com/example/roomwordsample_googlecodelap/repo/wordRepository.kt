package com.example.roomwordsample_googlecodelap.repo

import androidx.annotation.WorkerThread
import com.example.roomwordsample_googlecodelap.data.Word
import com.example.roomwordsample_googlecodelap.data.wordDao
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: wordDao) {

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}