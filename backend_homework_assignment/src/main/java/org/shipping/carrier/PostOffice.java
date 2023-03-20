package org.shipping.carrier;

import org.shipping.service.PackageSize;

import java.util.zip.DataFormatException;

/**
 * aka 'La Poste' or LP
 */
public class PostOffice implements Carrier {

    private double price;

    @Override
    public double getShippingPrice(PackageSize packageSize) {
        switch (packageSize) {
            case S -> price = 1.5;
            case M -> price = 4.90;
            case L -> price = 6.90;
            default -> throw new IllegalArgumentException("The package size is not recognised by PostOffice class");
        }
        return price;
    }
}
