package com.example.marsphotos

import com.example.marsphotos.fake.FakeDataSource
import com.example.marsphotos.fake.FakeMarsApiService
import com.example.marsphotos.fake.NetworkMarsPhotosRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkMarsPhotosRepositoryTest {
	@Test
	fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() {
		runTest {
			val repository = NetworkMarsPhotosRepository(
				marsApiService = FakeMarsApiService()
			)
			assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())
		}
	}
}