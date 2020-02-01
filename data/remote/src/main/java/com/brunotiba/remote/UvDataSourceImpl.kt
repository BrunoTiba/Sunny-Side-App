package com.brunotiba.remote

import com.brunotiba.remote.api.UvService
import com.brunotiba.remote.mapper.UvMapper
import com.brunotiba.repository.datasource.UvDataSource
import com.brunotiba.repository.model.Uv
import toothpick.InjectConstructor

@InjectConstructor
internal class UvDataSourceImpl(
    private val uvService: UvService,
    private val mapper: UvMapper
) : UvDataSource {

    override suspend fun getCurrentUvByCoordinates(lat: Double, lon: Double): Uv {
        val uv = uvService.getCurrentUv(lat, lon)
        return mapper.toRepository(uv)
    }
}
