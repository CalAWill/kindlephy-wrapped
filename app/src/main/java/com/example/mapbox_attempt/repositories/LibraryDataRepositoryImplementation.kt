package com.example.mapbox_attempt.repositories

class LibraryDataRepositoryImplementation(): LibraryDataRepository {
    override fun getLibraryData(amazonUsername: String, amazonPassword: String): LibraryData {
        return LibraryData(
            listOfBooks = listOf(
                Book("This is a test book",
                    "This is a description for the test book",
                    "Rumple Nobskin",
                    null,
                    "")
            ),
            completedBooks = 0
        )
    }
}