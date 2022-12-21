package com.example.booksearchapp.util

import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

@SmallTest
class CalculatorTest {
    private lateinit var calculator: Calculator
   
    @Before
    fun setup() {
        calculator = Calculator()
    }

    @After
    fun teardown() {
    }

    @Test
    fun `additional function test`() {
        // Given
        val x = 4
        val y = 2

        // When
        val result = calculator.addition(x, y)

        //Then
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `subtraction function test`() {
        // Given
        val x = 4
        val y = 2

        // When
        val result = calculator.subtraction(x, y)

        //Then
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `multiple function test`() {
        // Given
        val x = 4
        val y = 2

        // When
        val result = calculator.multiplication(x, y)

        //Then
        assertThat(result).isEqualTo(8)
    }

    @Test
    fun `division function test`() {
        // Given
        val x = 4
        val y = 0

        // When
        val result = calculator.division(x, y)

        //Then
        assertThat(result).isEqualTo(null)
    }
}
