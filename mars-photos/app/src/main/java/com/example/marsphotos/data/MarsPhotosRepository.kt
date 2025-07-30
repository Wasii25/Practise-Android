package com.example.marsphotos.data

import com.example.marsphotos.network.MarsApi
import com.example.marsphotos.network.MarsPhoto

interface MarsPhotosRepository {
    suspend fun getMarsPhotos() : List<MarsPhoto>
}

class NetworkMarsPhotosRepository() : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return MarsApi.retrofitService.getPhotos()
    }
}