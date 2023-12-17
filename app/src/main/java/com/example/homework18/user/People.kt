package com.example.homework18.user

data class People(
    //@SerializedName("data")
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)