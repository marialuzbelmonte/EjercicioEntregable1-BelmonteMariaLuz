package org.app.Logic.Payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentManagerTest {

    @Test
    public void testProcessPayment_Paypal() {
        PaymentRequest request = new PaymentRequest(150, "paypal");
        PaymentManager manager = new PaymentManager();

        boolean result = manager.processPayment(request);

        assertTrue(result);
    }

    @Test
    public void testProcessPayment_MercadoPago() {
        PaymentRequest request = new PaymentRequest(250, "mercadopago");
        PaymentManager manager = new PaymentManager();

        boolean result = manager.processPayment(request);

        assertTrue(result);
    }

    @Test
    public void testProcessPayment_InvalidProvider() {
        PaymentRequest request = new PaymentRequest(100, "otro");
        PaymentManager manager = new PaymentManager();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                manager.processPayment(request));

        assertEquals("Proveedor no soportado: otro", exception.getMessage());
    }
}

