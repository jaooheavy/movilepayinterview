package com.example.datasource.model

data class WidgetItemContentDto(
    val title: String = "",
    val balance: WidgetItemContentBalanceDto = WidgetItemContentBalanceDto(),
    val button: WidgetItemContentButtonDto = WidgetItemContentButtonDto()
)






