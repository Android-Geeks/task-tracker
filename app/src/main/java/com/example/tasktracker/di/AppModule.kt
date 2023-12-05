package com.example.tasktracker.di

import com.example.tasktracker.data.data_source.local.AppDao
import com.example.tasktracker.data.data_source.remote.RetrofitService
import com.example.tasktracker.data.repository.AppRepository
import com.example.tasktracker.data.repository.AppRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAppUseCases(appDao: AppDao, retrofitService: RetrofitService): AppRepository {
        return AppRepositoryImpl(appDao, retrofitService)
    }
}