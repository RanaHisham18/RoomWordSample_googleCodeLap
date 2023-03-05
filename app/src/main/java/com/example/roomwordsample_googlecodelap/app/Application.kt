package com.example.roomwordsample_googlecodelap.app

import android.app.Application
import android.content.Context
import com.example.roomwordsample_googlecodelap.data.wordRoomDatabase
import com.example.roomwordsample_googlecodelap.repo.wordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.coroutineContext

class Application : Application() {


    val applicationScope = CoroutineScope(SupervisorJob())
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { wordRoomDatabase.getDatabase(this, scope = applicationScope) }
    val repository by lazy { wordRepository(database.wordDao()) }
}