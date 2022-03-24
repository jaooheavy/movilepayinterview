package com.example.datasource.model

data class WidgetItemContentButtonDto(
    val text: String = "",
    val action: WidgetItemContentButtonActionDto = WidgetItemContentButtonActionDto()
)