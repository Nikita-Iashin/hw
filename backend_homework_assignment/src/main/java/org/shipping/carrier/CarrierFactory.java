package org.shipping.carrier;

public class CarrierFactory {
    public static Carrier create(String name) {
        return switch (name) {
            case "MR" -> new DropOffPoint();
            case "LP" -> new PostOffice();
            default -> throw new IllegalArgumentException("Unknown carrier name: " + name);
        };
    }
}

