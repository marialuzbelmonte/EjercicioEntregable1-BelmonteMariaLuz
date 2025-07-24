package org.app.Logic.Shipping;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ShippingCalculatorTest {

    @Test
    public void testCalculateCost_DelegatesToStrategy() {
        ShippingStrategy mockStrategy = Mockito.mock(ShippingStrategy.class);
        Dimensions dim = new Dimensions(2, 2, 2);
        ShippingRequest request = new ShippingRequest(5, dim, "Buenos Aires", "Córdoba");

        Mockito.when(mockStrategy.calculateCost(request)).thenReturn(321.99);

        ShippingCalculator calculator = new ShippingCalculator(request, mockStrategy);

        double cost = calculator.calculateCost();

        assertEquals(321.99, cost, 0.0001);
        Mockito.verify(mockStrategy, Mockito.times(1)).calculateCost(request);
    }
}

