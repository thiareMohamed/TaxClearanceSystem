package com.groupeisi.TaxClearanceSystem.service;

import com.groupeisi.TaxClearanceSystem.repository.PaymentRepository;
import com.groupeisi.TaxClearanceSystem.service.Dto.DeclarantDto;
import com.groupeisi.TaxClearanceSystem.service.Dto.DeclarationDto;
import com.groupeisi.TaxClearanceSystem.service.Dto.PaymentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    Logger logger = LoggerFactory.getLogger(PaymentService.class);
    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<PaymentDto> getAll() {
        return paymentRepository.findAll()
                .stream()
                .map(PaymentDto::toDto)
                .collect(Collectors.toList());
    }

    public Optional<PaymentDto> getOne(Long id) {
        return paymentRepository.findById(id)
                .map(PaymentDto::toDto);
    }

    public PaymentDto save(PaymentDto paymentDto) {
        return PaymentDto.toDto(paymentRepository.save(PaymentDto.toEntity(paymentDto)));
    }

    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }

    public PaymentDto update(Long id, PaymentDto paymentDto) {
        return paymentRepository.findById(id)
                .map(payment -> {
                    payment.setDate(paymentDto.getDate());
                    payment.setAmount(paymentDto.getAmount());
                    payment.setDeclaration(DeclarationDto.toEntity(paymentDto.getDeclarationDto()));
                    return PaymentDto.toDto(paymentRepository.save(payment));
                })
                .orElseGet(() -> {
                    paymentDto.setId(id);
                    return PaymentDto.toDto(paymentRepository.save(PaymentDto.toEntity(paymentDto)));
                });
    }
}
