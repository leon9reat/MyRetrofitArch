package com.medialink.myretrofitarch.data.repository

import com.medialink.myretrofitarch.data.local.CharacterDao
import com.medialink.myretrofitarch.data.remote.CharacterRemoteDataSource
import com.medialink.myretrofitarch.utils.performGetOperation
import timber.log.Timber
import javax.inject.Inject

class CharacterRepository
@Inject constructor(
    private val remoteDataSource: CharacterRemoteDataSource,
    private val localDataSource: CharacterDao
) {
    fun getCharacter(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getCharacter(id) },
        networkCall = { remoteDataSource.getCharacter(id) },
        saveCallResult = { localDataSource.insert(it) }
    )

    fun getCharacters() =
        performGetOperation(
            databaseQuery = { localDataSource.getAllCharacters() },
            networkCall = { remoteDataSource.getCharacters() },
            saveCallResult = { localDataSource.insertAll(it.results) }
        )
}