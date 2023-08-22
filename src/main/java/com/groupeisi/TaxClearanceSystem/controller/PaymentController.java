package com.groupeisi.TaxClearanceSystem.controller;

import com.groupeisi.TaxClearanceSystem.service.Dto.PaymentDto;
import com.groupeisi.TaxClearanceSystem.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class PaymentController {

    Logger logger = LoggerFactory.getLogger(PaymentService.class);
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments")
    public ResponseEntity<List<PaymentDto>> getAll() {
        logger.info("Getting all payments");
        return new ResponseEntity<>(paymentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/payments/{id}")
    public ResponseEntity<Optional<PaymentDto>> getOne(@PathVariable Long id) {
        logger.info("Getting payment with id {}", id);
        return new ResponseEntity<>(paymentService.getOne(id), HttpStatus.OK);
    }

    @PostMapping("/payments")
    public ResponseEntity<PaymentDto> save(@RequestBody PaymentDto paymentDto) {
        logger.info("Saving payment");
        return new ResponseEntity<>(paymentService.save(paymentDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/payments/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Deleting payment with id {}", id);
        paymentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/payments/{id}")
    public ResponseEntity<PaymentDto> update(@PathVariable Long id, @RequestBody PaymentDto paymentDto) {
        logger.info("Updating payment with id {}", id);
        return new ResponseEntity<>(paymentService.update(id, paymentDto), HttpStatus.OK);
    }

}
