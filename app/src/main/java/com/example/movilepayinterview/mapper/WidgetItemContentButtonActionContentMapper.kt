package com.example.movilepayinterview.mapper

import com.example.commons.mapper.DataMapper
import com.example.datasource.model.WidgetItemContentButtonActionContentDto
import com.example.movilepayinterview.model.WidgetItemContentButtonActionContent

class WidgetItemContentButtonActionContentMapper: DataMapper<WidgetItemContentButtonActionContentDto, WidgetItemContentButtonActionContent>() {
    override fun toDomain(data: WidgetItemContentButtonActionContentDto) = WidgetItemContentButtonActionContent(
        accountId = data.accountId
    )
}