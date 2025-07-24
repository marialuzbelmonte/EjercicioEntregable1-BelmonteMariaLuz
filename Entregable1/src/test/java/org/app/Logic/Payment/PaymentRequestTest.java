package org.app.Logic.Payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentRequestTest {

    @Test
    public void testConstructorAndGetters() {
        PaymentRequest request = new PaymentRequest(185.0, "paypal");

        assertEquals(185.0, request.getAmount());
        assertEquals("paypal", request.getProvider());
    }
}
