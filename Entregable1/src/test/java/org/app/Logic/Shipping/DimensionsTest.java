package org.app.Logic.Shipping;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DimensionsTest {

    @Test
    public void testGetVolume() {
        Dimensions dim = new Dimensions(5, 2, 2);
        assertEquals(20.0, dim.getVolume(), 0.0001);
    }
}
