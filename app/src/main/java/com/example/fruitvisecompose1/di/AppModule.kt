package com.example.fruityvisecompose1.di

import com.example.fruityvisecompose1.remote.ApiDetails
import com.example.fruityvisecompose1.repository.Repository
import com.example.fruityvisecompose1.repository.RepositoryImpl
import com.example.fruityvisecompose1.remote.ApiRequest
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

        @Provides
        fun provideGson(): Gson {
            return Gson()

        }

        @Provides
        fun provideOkhttp(): OkHttpClient {

            return OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                )
                .build()
        }

        @Provides
        @Singleton
        fun provideRetrofit(gson: Gson,
                            client: OkHttpClient
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl(ApiDetails.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
        }

        @Provides
        fun provideAPI(
            retrofit: Retrofit
        ): ApiRequest {
            return retrofit.create(ApiRequest::class.java)
        }

        @Provides
        fun provideRepository(apiRequest: ApiRequest): Repository {
            return RepositoryImpl(apiRequest)
        }



}