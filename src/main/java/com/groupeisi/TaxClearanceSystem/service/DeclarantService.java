package com.groupeisi.TaxClearanceSystem.service;

import com.groupeisi.TaxClearanceSystem.repository.DeclarantRepository;
import com.groupeisi.TaxClearanceSystem.service.Dto.DeclarantDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeclarantService {

    Logger logger = LoggerFactory.getLogger(PaymentService.class);
    private DeclarantRepository declarantRepository;

    public DeclarantService(DeclarantRepository declarantRepository) {
        this.declarantRepository = declarantRepository;
    }

    public List<DeclarantDto> getAllDeclarants() {
        return declarantRepository.findAll()
                .stream()
                .map(DeclarantDto::toDto)
                .collect(Collectors.toList());
    }

    public Optional<DeclarantDto> getDeclarantById(Long id) {
        return declarantRepository.findById(id)
                .map(DeclarantDto::toDto);
    }

    public DeclarantDto saveDeclarant(DeclarantDto declarantDto) {
        return DeclarantDto.toDto(declarantRepository.save(DeclarantDto.toEntity(declarantDto)));
    }

    public void deleteDeclarantById(Long id) {
        declarantRepository.deleteById(id);
    }

    public DeclarantDto updateDeclarant(Long id, DeclarantDto declarantDto) {
        return declarantRepository.findById(id)
                .map(declarant -> {
                    declarant.setSocialReason(declarantDto.getSocialReason());
                    declarant.setAddress(declarantDto.getAddress());
                    declarant.setEmail(declarantDto.getEmail());
                    declarant.setPhone(declarantDto.getPhone());
                    return DeclarantDto.toDto(declarantRepository.save(declarant));
                })
                .orElseGet(() -> {
                    declarantDto.setId(id);
                    return DeclarantDto.toDto(declarantRepository.save(DeclarantDto.toEntity(declarantDto)));
                });
    }

}
