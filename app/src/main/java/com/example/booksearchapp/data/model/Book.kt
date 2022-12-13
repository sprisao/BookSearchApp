package com.example.booksearchapp.data.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Book(
    val authors: List<String>,
    val contents: String,
    val datetime: String,
    val isbn: String,
    val price: Int,
    val publisher: String,
    @field:Json(name = "sale_price")
    val salePrice: Int,
    val status: String,
    val thumbnail: String,
    val title: String,
    val translators: List<String>,
    val url: String
) : Parcelable

//        "authors": [
//        "우재남",
//        "박길식"
//        ],
//        "contents": "1. 초보자도 쉽게 접근할 수 있도록 친절하게 설명합니다. 2. 프로그램을 단계별로 완성해가면서 코드에 대한 이해도를 높입니다. 3. 안드로이드 10.0(Q) 버전, Android Studio 3.5.1을 적용해서 실습합니다. 4. 원 클릭으로 모든 개발 환경이 구축되는 통합 실습 환경 파일을 제공합니다.",
//        "datetime": "2020-01-08T00:00:00.000+09:00",
//        "isbn": "1156644801 9791156644804",
//        "price": 29000,
//        "publisher": "한빛아카데미",
//        "sale_price": 28130,
//        "status": "정상판매",
//        "thumbnail": "https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F5209958%3Ftimestamp%3D20221209170858",
//        "title": "Android Studio를 활용한 안드로이드 프로그래밍",
//        "translators": [],
//        "url": "https://search.daum.net/search?w=bookpage&bookId=5209958&q=Android+Studio%EB%A5%BC+%ED%99%9C%EC%9A%A9%ED%95%9C+%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C+%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D"
