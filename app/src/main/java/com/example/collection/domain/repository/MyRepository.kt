package com.example.collection.domain.repository

interface MyRepository {
    suspend fun doNetworkCall()
}