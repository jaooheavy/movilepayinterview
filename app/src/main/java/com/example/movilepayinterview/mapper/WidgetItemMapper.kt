package com.example.movilepayinterview.mapper

import com.example.commons.mapper.DataMapper
import com.example.datasource.model.WidgetItemDto
import com.example.movilepayinterview.model.WidgetItem

class WidgetItemMapper(
    private val widgetItemContentMapper: WidgetItemContentMapper
): DataMapper<WidgetItemDto, WidgetItem>() {
    override fun toDomain(data: WidgetItemDto) = WidgetItem(
        identifier = data.identifier,
        content = widgetItemContentMapper.toDomain(data.content)
    )
}