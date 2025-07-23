package org.app.Logic.Shipping;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ShippingCalculatorTest {

    @Test
    public void testCalculateCost_DelegatesToStrategy() {
        ShippingStrategy mockStrategy = Mockito.mock(ShippingStrategy.class);
        Dimensions dim = new Dimensions(1, 1, 1);
        ShippingRequest request = new ShippingRequest(1, dim, "A", "B");

        Mockito.when(mockStrategy.calculateCost(request)).thenReturn(123.45);

        ShippingCalculator calculator = new ShippingCalculator(request, mockStrategy);

        double cost = calculator.calculateCost();

        assertEquals(123.45, cost, 0.0001);
        Mockito.verify(mockStrategy, Mockito.times(1)).calculateCost(request);
    }
}

