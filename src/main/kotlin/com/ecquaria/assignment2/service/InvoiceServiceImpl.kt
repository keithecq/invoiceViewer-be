package com.ecquaria.assignment2.service

import com.ecquaria.assignment2.dto.response.SubmissionResponse
import com.ecquaria.assignment2.model.Invoice
import com.ecquaria.assignment2.repository.InvoiceRepository
import com.ecquaria.assignment2.util.CSVUtils
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class InvoiceServiceImpl (
        val invoiceRepository : InvoiceRepository
        ) : InvoiceService {

    override fun uploadCSV(file: MultipartFile): ResponseEntity<SubmissionResponse> {
        val invoiceList: ArrayList<Invoice> = CSVUtils.csvToInvoice(file.inputStream)
        invoiceRepository.saveAll(invoiceList)
        val message = "Succesfully submitted CSV file. Rows Updated: ${invoiceList.size}"
        return ResponseEntity.ok().body(SubmissionResponse(message))
    }
}