package com.example.datasource.model

data class WidgetItemDto(
    val identifier: String = "",
    val content: WidgetItemContentDto = WidgetItemContentDto()
)
