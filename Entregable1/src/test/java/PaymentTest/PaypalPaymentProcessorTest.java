package PaymentTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.app.Logic.Payment.*;

public class PaypalPaymentProcessorTest {

    @Test
    public void testProcessPayment() {
        PaypalGateway gateway = new PaypalGateway();
        PaypalPaymentProcessor processor = new PaypalPaymentProcessor(gateway);
        assertTrue(processor.processPayment(200.0));
    }

    @Test
    public void testRefundPayment() {
        PaypalGateway gateway = new PaypalGateway();
        PaypalPaymentProcessor processor = new PaypalPaymentProcessor(gateway);
        assertTrue(processor.refundPayment(200.0));
    }
}
