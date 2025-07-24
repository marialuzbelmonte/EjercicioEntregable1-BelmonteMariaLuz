package org.app.Logic.Shipping;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ShippingRequestTest {
    @Test
    public void testGetters() {
        Dimensions dim = new Dimensions(4, 5, 6);
        ShippingRequest request = new ShippingRequest(20.75, dim, "Rafaela", "Buenos Aires");

        assertEquals(20.75, request.getWeight(), 0.0001);
        assertEquals(dim, request.getDimensions());
        assertEquals("Rafaela", request.getOrigin());
        assertEquals("Buenos Aires", request.getDestination());
    }
}


