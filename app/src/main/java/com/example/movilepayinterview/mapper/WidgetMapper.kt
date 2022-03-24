package com.example.movilepayinterview.mapper

import com.example.commons.mapper.DataMapper
import com.example.datasource.model.WidgetDto
import com.example.movilepayinterview.model.Widget

class WidgetMapper(
    private val widgetItemMapper: WidgetItemMapper
): DataMapper<WidgetDto, Widget>() {
    override fun toDomain(data: WidgetDto) = Widget(widgetItemMapper.mapList(data.widgets))
}









