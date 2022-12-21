package com.example.booksearchapp

import com.example.booksearchapp.data.db.BookSearchDaoTest
import com.example.booksearchapp.ui.view.MainActivityTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@ExperimenatalCoroutinesApi
@Suite.SuiteClasses(
    MainActivityTest::class,
    BookSearchDaoTest::class,
)
class InstrumentedTestSuites {
}

annotation class ExperimenatalCoroutinesApi
