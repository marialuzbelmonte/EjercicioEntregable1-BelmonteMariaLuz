package org.app.Logic.Payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

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
        when(gateway.authorize(180)).thenReturn(true);
        when(gateway.capture(180)).thenReturn(true);

        boolean result = processor.processPayment(180);

        assertTrue(result);
        verify(gateway).authorize(180);
        verify(gateway).capture(180);
    }

    @Test
    public void testProcessPayment_AuthorizeFails() {
        when(gateway.authorize(200)).thenReturn(false);
        when(gateway.capture(200)).thenReturn(true);

        boolean result = processor.processPayment(200);

        assertFalse(result);
        verify(gateway).authorize(200);
        verify(gateway, never()).capture(200);
    }

    @Test
    public void testProcessPayment_CaptureFails() {
        when(gateway.authorize(150)).thenReturn(true);
        when(gateway.capture(150)).thenReturn(false);

        boolean result = processor.processPayment(150);

        assertFalse(result);
        verify(gateway).authorize(150);
        verify(gateway).capture(150);
    }

    @Test
    public void testRefundPayment() {
        assertTrue(processor.refundPayment(80));
    }

}


