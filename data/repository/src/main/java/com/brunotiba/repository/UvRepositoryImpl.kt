package com.brunotiba.repository

import com.brunotiba.domain.model.Uv
import com.brunotiba.domain.repository.UvRepository
import com.brunotiba.repository.datasource.UvDataSource
import com.brunotiba.repository.mapper.UvMapper
import javax.inject.Inject

class UvRepositoryImpl @Inject constructor(
    private val uvDataSource: UvDataSource,
    private val uvMapper: UvMapper
) : UvRepository {

    override suspend fun getCurrentUvByCoordinates(lat: Double, lon: Double): Uv {
        val uv = uvDataSource.getCurrentUvByCoordinates(lat, lon)
        return uvMapper.toDomain(uv)
    }
}
