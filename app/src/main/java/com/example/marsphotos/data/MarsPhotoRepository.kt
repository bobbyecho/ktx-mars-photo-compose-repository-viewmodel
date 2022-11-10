package com.example.marsphotos.data

import com.example.marsphotos.model.MarsPhoto
import com.example.marsphotos.network.MarsApiService

interface MarsPhotoRepository {
	suspend fun getMarsPhotos(): List<MarsPhoto>
}

class MarsPhotoRepositoryImpl(private val marsApi: MarsApiService): MarsPhotoRepository {
	override suspend fun getMarsPhotos(): List<MarsPhoto> {
		return marsApi.getPhotos()
	}
}