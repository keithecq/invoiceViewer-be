package com.ecquaria.assignment2.util

import com.ecquaria.assignment2.model.Invoice
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.text.SimpleDateFormat

class CSVUtils {

    enum class CSVHeaders {
        InvoiceNo,StockCode,Description,Quantity,InvoiceDate,UnitPrice,CustomerID,Country
    }

    companion object {
        fun csvToInvoice(inputStream: InputStream): ArrayList<Invoice> {
            val invoiceList = ArrayList<Invoice>()
            val formatter = SimpleDateFormat("mm/dd/yyyy HH:mm")

            try {
                val fileReader = BufferedReader(InputStreamReader(inputStream, StandardCharsets.UTF_8))
                val csvParser = CSVParser(fileReader, CSVFormat.Builder.create()
                        .setTrim(true)
                        .setHeader(CSVHeaders::class.java)
                        .setSkipHeaderRecord(true)
                        .setIgnoreHeaderCase(true)
                        .setAllowMissingColumnNames(false)
                        .setAllowDuplicateHeaderNames(false)
                        .setCommentMarker('#')
                        .build())

                csvParser.records.forEach { csvRecord ->

                    val invoice = Invoice()
                    invoice.InvoiceNo = csvRecord[CSVHeaders.InvoiceNo]
                    invoice.StockCode = csvRecord[CSVHeaders.StockCode]
                    invoice.Description = csvRecord[CSVHeaders.Description]
                    invoice.Quantity = csvRecord[CSVHeaders.Quantity].toInt()
                    val date = formatter.parse(csvRecord[CSVHeaders.InvoiceDate])
                    invoice.InvoiceDate = date
                    invoice.UnitPrice = csvRecord[CSVHeaders.UnitPrice].toDouble()
                    invoice.CustomerID = csvRecord[CSVHeaders.CustomerID]
                    invoice.Country = csvRecord[CSVHeaders.Country]

                    invoiceList.add(invoice)
                }
                csvParser.close()
            } catch (e : IOException) {

            }

            return invoiceList
        }
    }
}