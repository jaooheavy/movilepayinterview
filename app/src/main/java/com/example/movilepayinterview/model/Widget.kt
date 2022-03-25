package com.example.movilepayinterview.model

data class Widget(
    val widgetItem: List<WidgetItem>
){
    val headerWidget get() =
        widgetItem.find { it.identifier == HOME_HEADER_WIDGET }

    val recyclerWidget get() =
        widgetItem.filter { it.identifier != HOME_HEADER_WIDGET }
}

const val HOME_HEADER_WIDGET = "HOME_HEADER_WIDGET"
