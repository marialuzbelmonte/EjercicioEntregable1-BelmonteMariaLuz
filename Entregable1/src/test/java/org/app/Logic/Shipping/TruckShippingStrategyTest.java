package org.app.Logic.Shipping;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TruckShippingStrategyTest {

    @Test
    public void testCalculateCost_LocalDestination() {
        Dimensions dim = new Dimensions(1, 1, 1);
        ShippingRequest request = new ShippingRequest(6, dim, "CityA", "CityA");
        TruckShippingStrategy strategy = new TruckShippingStrategy();

        // cost = 2.5 * 6 * 1.0 = 15.0
        double cost = strategy.calculateCost(request);
        assertEquals(15.0, cost, 0.0001);
    }

    @Test
    public void testCalculateCost_NonLocalDestination() {
        Dimensions dim = new Dimensions(1, 1, 1);
        ShippingRequest request = new ShippingRequest(6, dim, "CityA", "CityB");
        TruckShippingStrategy strategy = new TruckShippingStrategy();

        // cost = 2.5 * 6 * 1.5 = 22.5
        double cost = strategy.calculateCost(request);
        assertEquals(22.5, cost, 0.0001);
    }
}

