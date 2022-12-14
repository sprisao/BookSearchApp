package com.example.booksearchapp.data.repository

import com.example.booksearchapp.data.model.Book
import com.example.booksearchapp.data.model.SearchResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface BookSearchRepository {

    suspend fun searchBooks(
        query: String, sort: String, page: Int, size: Int
    ): Response<SearchResponse>

    suspend fun insertBooks(book: Book)
    suspend fun deleteBooks(book: Book)
    fun getFavoriteBooks(): Flow<List<Book>>
}
