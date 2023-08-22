package com.groupeisi.TaxClearanceSystem.repository;

import com.groupeisi.TaxClearanceSystem.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
