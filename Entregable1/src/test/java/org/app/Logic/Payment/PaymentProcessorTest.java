package org.app.Logic.Payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentProcessorTest {

    @Test
    public void testConstructorStoresGateway() {
        PaymentGateway gateway = new PaypalGateway();
        PaymentProcessor processor = new PaypalPaymentProcessor(gateway);

        assertNotNull(processor);
    }
}

