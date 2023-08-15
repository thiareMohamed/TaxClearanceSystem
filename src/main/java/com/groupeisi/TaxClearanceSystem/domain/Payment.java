package com.groupeisi.TaxClearanceSystem.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;
    private Double amount;

    @ManyToOne
    private Declaration declaration;

    public Payment() {
    }

    public Payment(LocalDate date, Double amount, Declaration declaration) {
        this.date = date;
        this.amount = amount;
        this.declaration = declaration;
    }

    public Long getId() {
        return id;
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

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", declaration=" + declaration +
                '}';
    }
}
