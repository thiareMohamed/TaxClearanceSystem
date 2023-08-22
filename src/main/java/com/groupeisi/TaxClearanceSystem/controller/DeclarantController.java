package com.groupeisi.TaxClearanceSystem.controller;

import com.groupeisi.TaxClearanceSystem.domain.Declarant;
import com.groupeisi.TaxClearanceSystem.service.DeclarantService;
import com.groupeisi.TaxClearanceSystem.service.Dto.DeclarantDto;
import com.groupeisi.TaxClearanceSystem.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping("/api") // This means URL's start with /api (after Application path)
public class DeclarantController {

    Logger logger = LoggerFactory.getLogger(PaymentService.class);
    private DeclarantService declarantService;

    public DeclarantController(DeclarantService declarantService) {
        this.declarantService = declarantService;
    }

    @GetMapping("/declarants")
    public ResponseEntity<List<DeclarantDto>> getAllDeclarants() {
        logger.info("Getting all declarants");
        return ResponseEntity.ok(declarantService.getAllDeclarants());
    }

    @GetMapping("/declarants/{id}")
    public ResponseEntity<DeclarantDto> getDeclarantById(@PathVariable Long id) {
        logger.info("Getting declarant with id {}", id);
        Optional<DeclarantDto> declarantDto = declarantService.getDeclarantById(id);
        return declarantDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/declarants")
    public ResponseEntity<DeclarantDto> saveDeclarant(@RequestBody DeclarantDto declarantDto) {
        logger.info("Saving declarant");
        return ResponseEntity.status(HttpStatus.CREATED).body(declarantService.saveDeclarant(declarantDto));
    }

    @DeleteMapping("/declarants/{id}")
    public ResponseEntity<Void> deleteDeclarantById(@PathVariable Long id) {
        logger.info("Deleting declarant with id {}", id);
        declarantService.deleteDeclarantById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/declarants/{id}")
    public ResponseEntity<DeclarantDto> updateDeclarant(@PathVariable Long id, @RequestBody DeclarantDto declarantDto) {
        logger.info("Updating declarant with id {}", id);
        return ResponseEntity.ok(declarantService.updateDeclarant(id, declarantDto));
    }
}
