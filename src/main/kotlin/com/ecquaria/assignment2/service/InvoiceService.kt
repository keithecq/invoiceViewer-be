package com.ecquaria.assignment2.service

import com.ecquaria.assignment2.dto.response.SubmissionResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
interface InvoiceService {
    fun uploadCSV(file: MultipartFile) : ResponseEntity<SubmissionResponse>
}