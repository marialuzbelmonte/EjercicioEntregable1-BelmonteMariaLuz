package org.app.Logic.Payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class PaypalPaymentProcessorTest {

    private PaymentGateway gateway;
    private PaypalPaymentProcessor processor;

    @BeforeEach
    public void setUp() {
        gateway = mock(PaymentGateway.class);
        processor = new PaypalPaymentProcessor(gateway);
    }

    @Test
    public void testProcessPayment_Success() {
        when(gateway.authorize(100)).thenReturn(true);
        when(gateway.capture(100)).thenReturn(true);

        boolean result = processor.processPayment(100);

        assertTrue(result);
        verify(gateway).authorize(100);
        verify(gateway).capture(100);
    }

    @Test
    public void testProcessPayment_AuthorizeFails() {
        when(gateway.authorize(100)).thenReturn(false);

        boolean result = processor.processPayment(100);

        assertFalse(result);
        verify(gateway).authorize(100);
        verify(gateway, never()).capture(anyDouble());
    }

    @Test
    public void testRefundPayment() {
        boolean result = processor.refundPayment(50);

        assertTrue(result);
    }
}

