package com.example.tasktracker.data.repository

import com.example.tasktracker.data.data_source.local.AppDao
import com.example.tasktracker.data.data_source.remote.RetrofitService

class AppRepositoryImpl(
    private val dao: AppDao,
    private val retrofitService: RetrofitService
) : AppRepository {

}