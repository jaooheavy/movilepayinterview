package com.example.movilepayinterview.mapper

import com.example.commons.mapper.DataMapper
import com.example.datasource.model.WidgetItemContentButtonDto
import com.example.movilepayinterview.model.WidgetItemContentButton

class WidgetItemContentButtonMapper(
    private val widgetItemContentButtonActionMapper: WidgetItemContentButtonActionMapper
): DataMapper<WidgetItemContentButtonDto, WidgetItemContentButton>() {
    override fun toDomain(data: WidgetItemContentButtonDto) = WidgetItemContentButton(
        text = data.text,
        action = widgetItemContentButtonActionMapper.toDomain(data.action)
    )
}