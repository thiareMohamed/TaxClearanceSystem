package com.groupeisi.TaxClearanceSystem.service.Dto;

import com.groupeisi.TaxClearanceSystem.domain.Declaration;
import com.groupeisi.TaxClearanceSystem.domain.Payment;

import java.time.LocalDate;

public class PaymentDto {

    private Long id;
    private LocalDate date;
    private Double amount;
    private DeclarationDto declarationDto;

    public PaymentDto() {
    }

    public PaymentDto(LocalDate date, Double amount, DeclarationDto declarationDto) {
        this.date = date;
        this.amount = amount;
        this.declarationDto = declarationDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeclarationDto getDeclarationDto() {
        return declarationDto;
    }

    public void setDeclarationDto(DeclarationDto declarationDto) {
        this.declarationDto = declarationDto;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentDto{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", declarationDto=" + declarationDto +
                '}';
    }

    public static PaymentDto toDto(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setId(payment.getId());
        paymentDto.setDate(payment.getDate());
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setDeclarationDto(DeclarationDto.toDto(payment.getDeclaration()));
        return paymentDto;
    }

    public static Payment toEntity(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setId(paymentDto.getId());
        payment.setDate(paymentDto.getDate());
        payment.setAmount(paymentDto.getAmount());
        payment.setDeclaration(DeclarationDto.toEntity(paymentDto.getDeclarationDto()));
        return payment;
    }
}
