package com.groupeisi.TaxClearanceSystem.repository;

import com.groupeisi.TaxClearanceSystem.domain.Declaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarationRepository extends JpaRepository<Declaration, Long> {
}
