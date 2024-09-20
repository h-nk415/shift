package com.example.shift.service;

import java.util.List;

import com.example.shift.entity.Payments;

public interface PaymentsService {
	
	void savePayment(Payments payment);

    Payments getPaymentById(Integer id);

    List<Payments> getAllPayments();

    void updatePayment(Payments payment);

    void deletePayment(Integer id);

    List<Payments> getMonthlyPayments();

}
