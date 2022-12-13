package com.example.booksearchapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.booksearchapp.data.model.Book

@Dao
interface BookSearchDao {
   
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)

    @Query("SELECT * FROM books")
    fun getFavoriteBooks(): LiveData<List<Book>>
}
