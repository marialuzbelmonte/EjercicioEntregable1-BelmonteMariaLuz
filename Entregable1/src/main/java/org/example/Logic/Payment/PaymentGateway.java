package org.example.Logic.Payment;

public interface PaymentGateway {
    boolean authorize(double amount);
    boolean capture(double amount);
}
