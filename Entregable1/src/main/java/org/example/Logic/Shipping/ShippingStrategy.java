package org.example.Logic.Shipping;

public interface ShippingStrategy {
    double calculateCost(ShippingRequest shippingRequest);
}
