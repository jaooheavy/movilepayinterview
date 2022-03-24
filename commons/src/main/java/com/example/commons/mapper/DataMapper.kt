package com.example.commons.mapper

abstract class DataMapper<in R, out D> {
    abstract fun toDomain(data: R): D

    fun mapList(list: List<R>) = list.map { toDomain(it) }
}