package com.example.mapbox_attempt.repositories

interface LibraryDataRepository {
    fun getLibraryData(amazonUsername: String, amazonPassword: String): LibraryData
}