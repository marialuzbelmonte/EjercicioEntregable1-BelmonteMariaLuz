package org.app.Logic.Shipping;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AirShippingStrategyTest {

    @Test
    public void testCalculateCost() {
        Dimensions dim = new Dimensions(3, 2, 1); // volume = 6
        ShippingRequest request = new ShippingRequest(12, dim, "A", "B");
        AirShippingStrategy strategy = new AirShippingStrategy();

        // cálculo --> cost = 5.0 * 12 + 0.02 * 6 = 60 + 0.12 = 60.12
        double cost = strategy.calculateCost(request);
        assertEquals(60.12, cost, 0.0001);
    }
}


