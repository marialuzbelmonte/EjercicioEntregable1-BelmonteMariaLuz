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
        when(gateway.authorize(120)).thenReturn(true);
        when(gateway.capture(120)).thenReturn(true);

        boolean result = processor.processPayment(120);

        assertTrue(result);
        verify(gateway).authorize(120);
        verify(gateway).capture(120);
    }

    @Test
    public void testProcessPayment_AuthorizeFails() {
        when(gateway.authorize(130)).thenReturn(false);

        boolean result = processor.processPayment(130);

        assertFalse(result);
        verify(gateway).authorize(130);
        verify(gateway, never()).capture(anyDouble());
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
        boolean result = processor.refundPayment(70);

        assertTrue(result);
    }
}



