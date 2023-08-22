package com.groupeisi.TaxClearanceSystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Declaration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "declarant_id")
    private Declarant declarant;

    @OneToMany(mappedBy = "declaration")
    private List<Payment> payments;

    public Declaration() {
    }

    public Declaration(LocalDate date, Double amount, Declarant declarant, List<Payment> payments) {
        this.date = date;
        this.amount = amount;
        this.declarant = declarant;
        this.payments = payments;
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

    public Declarant getDeclarant() {
        return declarant;
    }

    public void setDeclarant(Declarant declarant) {
        this.declarant = declarant;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Declaration{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", declarant=" + declarant +
                '}';
    }
}
