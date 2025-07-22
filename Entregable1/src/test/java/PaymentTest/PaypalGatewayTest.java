package PaymentTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.app.Logic.Payment.PaypalGateway;

public class PaypalGatewayTest {

    @Test
    public void testAuthorize() {
        PaypalGateway gateway = new PaypalGateway();
        assertTrue(gateway.authorize(100.0));
    }

    @Test
    public void testCapture() {
        PaypalGateway gateway = new PaypalGateway();
        assertTrue(gateway.capture(100.0));
    }
}
