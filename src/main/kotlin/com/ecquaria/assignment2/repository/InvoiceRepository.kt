package com.ecquaria.assignment2.repository

import com.ecquaria.assignment2.model.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository : JpaRepository<Invoice, String>, InvoiceRepositoryCustom {
}