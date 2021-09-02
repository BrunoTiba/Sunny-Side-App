package com.brunotiba.remote

import com.brunotiba.remote.api.UvService
import com.brunotiba.remote.mapper.UvMapper
import com.brunotiba.repository.datasource.UvDataSource
import com.brunotiba.repository.model.Uv
import javax.inject.Inject

class UvDataSourceImpl @Inject constructor(
    private val uvService: UvService,
    private val mapper: UvMapper
) : UvDataSource {

    override suspend fun getCurrentUvByCoordinates(lat: Double, lon: Double): Uv {
        val uv = uvService.getCurrentUv(lat, lon)
        return mapper.toRepository(uv)
    }
}
