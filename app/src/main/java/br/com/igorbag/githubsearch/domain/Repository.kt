package br.com.igorbag.githubsearch.domain

import com.google.gson.annotations.SerializedName

data class Repository(
    val name: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    val language: String,
    @SerializedName("watchers_count")
    val watchersCount: Int,
    @SerializedName("stargazers_count")
    val stargazersCount: Int
)