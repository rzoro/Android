/*
 * Copyright (c) 2017 DuckDuckGo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.duckduckgo.app.di

import android.content.Context
import androidx.room.Room
import com.duckduckgo.app.global.db.AppDatabase
import com.duckduckgo.app.global.db.AppDatabase.Companion.MIGRATION_1_TO_2
import com.duckduckgo.app.global.db.AppDatabase.Companion.MIGRATION_2_TO_3
import com.duckduckgo.app.global.db.AppDatabase.Companion.MIGRATION_3_TO_4
import com.duckduckgo.app.global.db.AppDatabase.Companion.MIGRATION_4_TO_5
import com.duckduckgo.app.global.db.AppDatabase.Companion.MIGRATION_5_TO_6
import com.duckduckgo.app.global.db.AppDatabase.Companion.MIGRATION_6_TO_7
import com.duckduckgo.app.global.db.AppDatabase.Companion.MIGRATION_7_TO_8
import com.duckduckgo.app.global.db.AppDatabase.Companion.MIGRATION_8_TO_9
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DaoModule::class])
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "app.db")
            .addMigrations(
                MIGRATION_1_TO_2,
                MIGRATION_2_TO_3,
                MIGRATION_3_TO_4,
                MIGRATION_4_TO_5,
                MIGRATION_5_TO_6,
                MIGRATION_6_TO_7,
                MIGRATION_7_TO_8,
                MIGRATION_8_TO_9
            )
            .build()
    }

}
