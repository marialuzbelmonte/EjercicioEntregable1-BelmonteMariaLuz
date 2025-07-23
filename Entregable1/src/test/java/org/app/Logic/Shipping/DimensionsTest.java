package org.app.Logic.Shipping;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DimensionsTest {

    @Test
    public void testGetVolume() {
        Dimensions dim = new Dimensions(2, 3, 4);
        assertEquals(24.0, dim.getVolume(), 0.0001);
    }
}
