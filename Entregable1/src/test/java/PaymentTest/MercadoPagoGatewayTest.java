package PaymentTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.app.Logic.Payment.MercadoPagoGateway;

public class MercadoPagoGatewayTest {

    @Test
    public void testAuthorize() {
        MercadoPagoGateway gateway = new MercadoPagoGateway();
        assertTrue(gateway.authorize(150.0));
    }

    @Test
    public void testCapture() {
        MercadoPagoGateway gateway = new MercadoPagoGateway();
        assertTrue(gateway.capture(150.0));
    }
}