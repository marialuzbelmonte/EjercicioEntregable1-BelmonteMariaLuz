package org.app.Logic.Shipping;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BoatShippingStrategyTest {
    @Test
    public void testCalculateCost() {
        Dimensions dim = new Dimensions(2, 3, 2); // volume = 12
        ShippingRequest request = new ShippingRequest(6, dim, "X", "Y");
        BoatShippingStrategy strategy = new BoatShippingStrategy();

        // cálculo --> cost = 3.0 + 0.01 * 12 + 0.5 * 6 = 3 + 0.12 + 3 = 6.12
        double cost = strategy.calculateCost(request);
        assertEquals(6.12, cost, 0.0001);
    }
}


