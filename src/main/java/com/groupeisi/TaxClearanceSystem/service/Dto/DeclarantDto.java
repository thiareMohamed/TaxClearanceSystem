package com.groupeisi.TaxClearanceSystem.service.Dto;

import com.groupeisi.TaxClearanceSystem.domain.Declarant;

import java.util.List;

public class DeclarantDto {

    private Long id;
    private String socialReason;
    private String address;
    private String email;
    private String phone;
    private List<DeclarationDto> declarationDtos;

    public DeclarantDto() {
    }

    public DeclarantDto(String socialReason, String address, String email, String phone, List<DeclarationDto> declarationDtos) {
        this.socialReason = socialReason;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.declarationDtos = declarationDtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DeclarationDto> getDeclarationDtos() {
        return declarationDtos;
    }

    public void setDeclarationDtos(List<DeclarationDto> declarationDtos) {
        this.declarationDtos = declarationDtos;
    }

    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "DeclarantDto{" +
                "id=" + id +
                ", socialReason='" + socialReason + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", declarationDtos=" + declarationDtos +
                '}';
    }

    public static Declarant toEntity(DeclarantDto declarantDto) {
        Declarant declarant = new Declarant();
        declarant.setSocialReason(declarantDto.getSocialReason());
        declarant.setAddress(declarantDto.getAddress());
        declarant.setEmail(declarantDto.getEmail());
        declarant.setPhone(declarantDto.getPhone());
        return declarant;
    }

    public static DeclarantDto toDto(Declarant declarant) {
        DeclarantDto declarantDto = new DeclarantDto();
        declarantDto.setId(declarant.getId());
        declarantDto.setSocialReason(declarant.getSocialReason());
        declarantDto.setAddress(declarant.getAddress());
        declarantDto.setEmail(declarant.getEmail());
        declarantDto.setPhone(declarant.getPhone());
        return declarantDto;
    }
}
