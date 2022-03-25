package com.example.movilepayinterview

import com.example.movilepayinterview.mapper.*

object StubFactory {
    val widgetMapper = WidgetMapper(
        WidgetItemMapper(
            WidgetItemContentMapper(
                WidgetItemContentBalanceMapper(),
                WidgetItemContentButtonMapper(
                    WidgetItemContentButtonActionMapper(
                        WidgetItemContentButtonActionContentMapper()
                    )
                )
            )
        )
    )

    val cardMapper = CardMapper()

    val statementMapper = StatementMapper(
        StatementBalanceMapper(),
        StatementTransactionMapper()
    )
}