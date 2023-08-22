package com.groupeisi.TaxClearanceSystem.controller;

import com.groupeisi.TaxClearanceSystem.service.DeclarationService;
import com.groupeisi.TaxClearanceSystem.service.Dto.DeclarationDto;
import com.groupeisi.TaxClearanceSystem.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class DeclarationController {

    Logger logger = LoggerFactory.getLogger(PaymentService.class);
    private DeclarationService declarationService;

    public DeclarationController(DeclarationService declarationService) {
        this.declarationService = declarationService;
    }

    @GetMapping("/declarations")
    public List<DeclarationDto> getAll() {
        logger.info("Getting all declarations");
        return declarationService.getAll();
    }

    @GetMapping("/declarations/{id}")
    public Optional<DeclarationDto> getOne(@PathVariable Long id) {
        logger.info("Getting declaration with id {}", id);
        return declarationService.getOne(id);
    }

    @PostMapping("/declarations")
    public DeclarationDto save(@RequestBody DeclarationDto declarationDto) {
        logger.info("Saving declaration");
        return declarationService.save(declarationDto);
    }

    @DeleteMapping("/declarations/{id}")
    public void delete(@PathVariable Long id) {
        logger.info("Deleting declaration with id {}", id);
        declarationService.delete(id);
    }

    @PutMapping("/declarations/{id}")
    public DeclarationDto update(@PathVariable Long id, @RequestBody DeclarationDto declarationDto) {
        logger.info("Updating declaration with id {}", id);
        return declarationService.update(id, declarationDto);
    }
}
