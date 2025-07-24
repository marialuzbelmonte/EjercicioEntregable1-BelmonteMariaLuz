package org.app.Logic.Payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MercadoPagoGatewayTest {

    @Test
    public void testAuthorize() {
        MercadoPagoGateway gateway = new MercadoPagoGateway();
        boolean result = gateway.authorize(150.0);
        assertTrue(result);
    }

    @Test
    public void testCapture() {
        MercadoPagoGateway gateway = new MercadoPagoGateway();
        boolean result = gateway.capture(150.0);
        assertTrue(result);
    }
}
