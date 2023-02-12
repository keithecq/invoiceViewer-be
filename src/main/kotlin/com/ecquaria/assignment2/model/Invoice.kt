package com.ecquaria.assignment2.model

import java.time.LocalDateTime
import java.util.Date
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Invoice (
    //InvoiceNo,StockCode,Description,Quantity,InvoiceDate,UnitPrice,CustomerID,Country
        // 536365,85123A,WHITE HANGING HEART T-LIGHT HOLDER,6,12/1/2010 8:26,2.55,17850,United Kingdom
        // Some records inside are missing, some InvoiceNo have string in them, bascially do checks on them
        @Id
    var InvoiceNo: String = "",

    var StockCode: String = "",

    var Description: String = "",

    var Quantity: Int = 0,

    var InvoiceDate: Date = Date(),

    var UnitPrice: Double = 0.0,

    var CustomerID: String = "",

    var Country: String = "",
)