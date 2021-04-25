package com.manuh.share.witinterviewapplication.di

import android.app.Application
import androidx.room.Room.databaseBuilder
import com.manuh.share.witinterviewapplication.dao.ItemDao
import com.manuh.share.witinterviewapplication.source.database.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDB(application: Application?): Database {
        return databaseBuilder(
            application!!.applicationContext,
            Database::class.java,
            "Items_Database"
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideItemDao(database: Database): ItemDao {
        return database.itemDao()!!
    }
}