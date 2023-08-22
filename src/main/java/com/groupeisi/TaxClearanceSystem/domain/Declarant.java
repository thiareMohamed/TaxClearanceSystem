package com.groupeisi.TaxClearanceSystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Declarant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String socialReason;
    private String address;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "declarant")
    private List<Declaration> declarations;


    public Declarant() {
    }

    public Declarant(String socialReason, String address, String email, String phone, List<Declaration> declarations) {
        this.socialReason = socialReason;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.declarations = declarations;
    }


    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Declaration> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(List<Declaration> declarations) {
        this.declarations = declarations;
    }

    public String toString() {
        return "Declarant{" +
                "id=" + id +
                ", socialReason='" + socialReason + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }


}
