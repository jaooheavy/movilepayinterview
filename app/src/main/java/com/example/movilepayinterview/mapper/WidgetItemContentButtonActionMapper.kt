package com.example.movilepayinterview.mapper

import com.example.commons.mapper.DataMapper
import com.example.datasource.model.WidgetItemContentButtonActionDto
import com.example.movilepayinterview.model.WidgetItemContentButtonAction

class WidgetItemContentButtonActionMapper(
    private val widgetItemContentButtonActionContentMapper: WidgetItemContentButtonActionContentMapper
): DataMapper<WidgetItemContentButtonActionDto, WidgetItemContentButtonAction>() {
    override fun toDomain(data: WidgetItemContentButtonActionDto) = WidgetItemContentButtonAction(
        identifier = data.identifier,
        content = widgetItemContentButtonActionContentMapper.toDomain(data.content)
    )
}