package org.app.Logic.Shipping;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TruckShippingStrategyTest {

    @Test
    public void testCalculateCost_LocalDestination() {
        Dimensions dim = new Dimensions(1, 1, 1);
        ShippingRequest request = new ShippingRequest(4, dim, "CityA", "CityA");
        TruckShippingStrategy strategy = new TruckShippingStrategy();

        // cost = 2.5 * 4 * 1.0 = 10.0
        double cost = strategy.calculateCost(request);
        assertEquals(10.0, cost, 0.0001);
    }

    @Test
    public void testCalculateCost_NonLocalDestination() {
        Dimensions dim = new Dimensions(1, 1, 1);
        ShippingRequest request = new ShippingRequest(5, dim, "CityA", "CityB");
        TruckShippingStrategy strategy = new TruckShippingStrategy();

        // cost = 2.5 * 5 * 1.5 = 18.75
        double cost = strategy.calculateCost(request);
        assertEquals(18.75, cost, 0.0001);
    }
}
