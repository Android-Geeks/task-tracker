package com.example.tasktracker.di

import android.app.Application
import androidx.room.Room
import com.example.tasktracker.data.data_source.local.AppDatabase
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
object LocalModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideEntityRepository(db: AppDatabase, retrofitService: RetrofitService): AppRepository {
        return AppRepositoryImpl(db.appDao, retrofitService)
    }

}