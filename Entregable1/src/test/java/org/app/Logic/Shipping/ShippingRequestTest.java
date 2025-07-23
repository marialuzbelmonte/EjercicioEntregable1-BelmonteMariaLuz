package org.app.Logic.Shipping;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ShippingRequestTest {
    @Test
    public void testGetters() {
        Dimensions dim = new Dimensions(1, 2, 3);
        ShippingRequest request = new ShippingRequest(10.5, dim, "Origen", "Destino");

        assertEquals(10.5, request.getWeight(), 0.0001);
        assertEquals(dim, request.getDimensions());
        assertEquals("Origen", request.getOrigin());
        assertEquals("Destino", request.getDestination());
    }
}

