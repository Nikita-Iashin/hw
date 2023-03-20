package org.shipping.service;

import org.shipping.carrier.Carrier;
import org.shipping.carrier.CarrierFactory;

import java.time.LocalDate;

public class Transaction {

    private LocalDate localDate;
    private PackageSize packageSize;
    private Carrier carrier;
    private Double price;
    private Double discount;

    public Transaction(String row) {
        String[] parts = row.split(" ");
        localDate = LocalDate.parse(parts[0]);
        packageSize = PackageSize.valueOf(parts[1]);
        carrier = CarrierFactory.create(parts[2]);
        price = carrier.getShippingPrice(packageSize);
        discount = 0.0;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public PackageSize getPackageSize() {
        return packageSize;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public Double getPrice() {
        return price;
    }

    public Double getDiscount() {
        return discount;
    }
}
