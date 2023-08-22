package com.groupeisi.TaxClearanceSystem.service;

import com.groupeisi.TaxClearanceSystem.repository.DeclarationRepository;
import com.groupeisi.TaxClearanceSystem.service.Dto.DeclarantDto;
import com.groupeisi.TaxClearanceSystem.service.Dto.DeclarationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeclarationService {

    Logger logger = LoggerFactory.getLogger(PaymentService.class);
    private DeclarationRepository declarationRepository;

    public DeclarationService(DeclarationRepository declarationRepository) {
        this.declarationRepository = declarationRepository;
    }

    public List<DeclarationDto> getAll() {
        return declarationRepository.findAll()
                .stream()
                .map(DeclarationDto::toDto)
                .collect(Collectors.toList());
    }

    public Optional<DeclarationDto> getOne(Long id) {
        return declarationRepository.findById(id)
                .map(DeclarationDto::toDto);
    }

    public DeclarationDto save(DeclarationDto declarationDto) {
        return DeclarationDto.toDto(declarationRepository.save(DeclarationDto.toEntity(declarationDto)));
    }

    public void delete(Long id) {
        declarationRepository.deleteById(id);
    }

    public DeclarationDto update(Long id, DeclarationDto declarationDto) {
        return declarationRepository.findById(id)
                .map(declaration -> {
                    declaration.setDate(declarationDto.getDate());
                    declaration.setDeclarant(DeclarantDto.toEntity(declarationDto.getDeclarantDto()));
                    return DeclarationDto.toDto(declarationRepository.save(declaration));
                })
                .orElseGet(() -> {
                    declarationDto.setId(id);
                    return DeclarationDto.toDto(declarationRepository.save(DeclarationDto.toEntity(declarationDto)));
                });
    }

}
