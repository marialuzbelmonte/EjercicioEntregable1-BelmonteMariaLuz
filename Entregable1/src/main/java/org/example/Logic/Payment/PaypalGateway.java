package org.example.Logic.Payment;

public class PaypalGateway implements PaymentGateway{
    @Override
    public boolean authorize(double amount) {
        System.out.println("[PayPal Gateway] Autorizando pago de $" + amount);
        return true;
    }

    @Override
    public boolean capture(double amount) {
        System.out.println("[PayPal Gateway] Capturando pago de $" + amount);
        return true;
    }
}
