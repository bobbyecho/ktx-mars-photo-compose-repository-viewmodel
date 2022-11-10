package com.example.marsphotos.fake

import com.example.marsphotos.data.MarsPhotoRepository
import com.example.marsphotos.model.MarsPhoto

class NetworkMarsPhotosRepository(private val marsApiService: FakeMarsApiService): MarsPhotoRepository {
	override suspend fun getMarsPhotos(): List<MarsPhoto> {
		return marsApiService.getPhotos()
	}
}
