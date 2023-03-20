package org.shipping.carrier;

import org.shipping.service.PackageSize;

/**
 * aka 'Mondial Relay' or MR
 */
public class DropOffPoint implements Carrier {

    private double price;

    @Override
    public double getShippingPrice(PackageSize packageSize) {
        switch (packageSize) {
            case S -> price = 2.0;
            case M -> price = 3.0;
            case L -> price = 4.0;
            default -> throw new IllegalArgumentException("The package size is not recognised by DropOffice class");
        }
        return price;
    }
}

