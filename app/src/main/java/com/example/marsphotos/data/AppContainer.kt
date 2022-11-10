package com.example.marsphotos.data

import com.example.marsphotos.network.MarsApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

interface AppContainer {
	val marsPhotoRepository: MarsPhotoRepository
}

class AppContainerImpl : AppContainer {
	private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

	@OptIn(ExperimentalSerializationApi::class)
	private val retrofit: Retrofit = Retrofit.Builder()
		.addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
		.baseUrl(BASE_URL)
		.build()

	private val retrofitService: MarsApiService by lazy {
		retrofit.create(MarsApiService::class.java)
	}

	override val marsPhotoRepository: MarsPhotoRepository by lazy {
		MarsPhotoRepositoryImpl(retrofitService)
	}
}