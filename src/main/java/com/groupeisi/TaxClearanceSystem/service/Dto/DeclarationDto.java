package com.groupeisi.TaxClearanceSystem.service.Dto;

import com.groupeisi.TaxClearanceSystem.domain.Declarant;
import com.groupeisi.TaxClearanceSystem.domain.Declaration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeclarationDto {

    private Long id;

    private LocalDate date;
    private Double amount;
    private DeclarantDto declarantDto;
    private List<PaymentDto> paymentDtos;

    public DeclarationDto() {
    }

    public DeclarationDto(LocalDate date, Double amount, DeclarantDto declarantDto, List<PaymentDto> paymentDtos) {
        this.date = date;
        this.amount = amount;
        this.declarantDto = declarantDto;
        this.paymentDtos = paymentDtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public DeclarantDto getDeclarantDto() {
        return declarantDto;
    }

    public void setDeclarantDto(DeclarantDto declarantDto) {
        this.declarantDto = declarantDto;
    }

    public List<PaymentDto> getPaymentDtos() {
        return paymentDtos;
    }

    public void setPaymentDtos(List<PaymentDto> paymentDtos) {
        this.paymentDtos = paymentDtos;
    }

    @Override
    public String toString() {
        return "DeclarationDto{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", declarantDto=" + declarantDto +
                ", paymentDtos=" + paymentDtos +
                '}';
    }

    public static DeclarationDto toDto(Declaration declaration) {
        return new DeclarationDto(
                declaration.getDate(),
                declaration.getAmount(),
                DeclarantDto.toDto(declaration.getDeclarant()),
                declaration.getPayments().stream().map(PaymentDto::toDto).collect(Collectors.toList())
        );
    }

    public static Declaration toEntity(DeclarationDto declarationDto) {
        if (declarationDto.getPaymentDtos() == null){
            return new Declaration(
                    declarationDto.getDate(),
                    declarationDto.getAmount(),
                    DeclarantDto.toEntity(declarationDto.getDeclarantDto()),
                    new ArrayList<>()
            );
        }
        return new Declaration(
                declarationDto.getDate(),
                declarationDto.getAmount(),
                DeclarantDto.toEntity(declarationDto.getDeclarantDto()),
                declarationDto.getPaymentDtos().stream().map(PaymentDto::toEntity).collect(Collectors.toList())
        );
    }

}
