package com.example.booksearchapp.ui.viewmodel

import androidx.test.filters.MediumTest
import com.example.booksearchapp.data.model.Book
import com.example.booksearchapp.data.repository.FakeBookSearchRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@MediumTest
class BookViewModelTest {
    private lateinit var viewModel: BookViewModel

    @Before
    fun setup() {
        viewModel = BookViewModel(FakeBookSearchRepository())
    }


    @Test
    @ExperimentalCoroutinesApi
    fun save_book_test() = runTest {
        val book = Book(
            title = "title",
            contents = "contents",
            url = "url",
            isbn = "isbn",
            datetime = "datetime",
            authors = listOf("author"),
            publisher = "publisher",
            translators = listOf("translator"),
            price = 1000,
            salePrice = 1000,
            thumbnail = "thumbnail",
            status = "status"
        )

        viewModel.saveBook(book)

        val favoriteBooks = viewModel.favoriteBooks.first()
        assertThat(favoriteBooks).contains(book)
    }
}
