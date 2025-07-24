package org.app.Logic.Payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaypalGatewayTest {

    @Test
    public void testAuthorize() {
        PaypalGateway gateway = new PaypalGateway();
        boolean result = gateway.authorize(275.0);
        assertTrue(result);
    }

    @Test
    public void testCapture() {
        PaypalGateway gateway = new PaypalGateway();
        boolean result = gateway.capture(275.0);
        assertTrue(result);
    }
}

