package com.groupeisi.TaxClearanceSystem.repository;

import com.groupeisi.TaxClearanceSystem.domain.Declarant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarantRepository extends JpaRepository<Declarant, Long> {
}
