package org.app.Logic.Payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentManagerTest {

    @Test
    public void testProcessPayment_Paypal() {
        PaymentRequest request = new PaymentRequest(175, "paypal");
        PaymentManager manager = new PaymentManager();

        boolean result = manager.processPayment(request);

        assertTrue(result);
    }

    @Test
    public void testProcessPayment_MercadoPago() {
        PaymentRequest request = new PaymentRequest(280, "mercadopago");
        PaymentManager manager = new PaymentManager();

        boolean result = manager.processPayment(request);

        assertTrue(result);
    }

    @Test
    public void testProcessPayment_InvalidProvider() {
        PaymentRequest request = new PaymentRequest(90, "desconocido");
        PaymentManager manager = new PaymentManager();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                manager.processPayment(request));

        assertEquals("Proveedor no valido: desconocido", exception.getMessage());
    }
}








