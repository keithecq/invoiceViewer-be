package com.ecquaria.assignment2.controller

import com.ecquaria.assignment2.dto.response.SubmissionResponse
import com.ecquaria.assignment2.service.InvoiceService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class InvoiceController(
        private val invoiceService: InvoiceService) {

    @PostMapping(path = ["/uploadCSV"], consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun uploadCSV(@RequestParam("file") file: MultipartFile): ResponseEntity<SubmissionResponse> {
        return invoiceService.uploadCSV(file)
    }
}