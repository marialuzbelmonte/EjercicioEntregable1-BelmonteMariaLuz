package org.app.Logic.Payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class MercadoPagoPaymentProcessorTest {
    private PaymentGateway gateway;
    private MercadoPagoPaymentProcessor processor;

    @BeforeEach
    public void setUp() {
        gateway = mock(PaymentGateway.class);
        processor = new MercadoPagoPaymentProcessor(gateway);
    }

    @Test
    public void testProcessPayment_Success() {
        when(gateway.authorize(200)).thenReturn(true);
        when(gateway.capture(200)).thenReturn(true);

        boolean result = processor.processPayment(200);

        assertTrue(result);
        verify(gateway).authorize(200);
        verify(gateway).capture(200);
    }

    @Test
    public void testProcessPayment_CaptureFails() {
        when(gateway.authorize(200)).thenReturn(true);
        when(gateway.capture(200)).thenReturn(false);

        boolean result = processor.processPayment(200);

        assertFalse(result);
        verify(gateway).authorize(200);
        verify(gateway).capture(200);
    }

    @Test
    public void testRefundPayment() {
        assertTrue(processor.refundPayment(80));
    }
}

