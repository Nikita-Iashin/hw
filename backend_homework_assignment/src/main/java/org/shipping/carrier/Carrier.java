package org.shipping.carrier;

import org.shipping.service.PackageSize;

public interface Carrier {

    public double getShippingPrice(PackageSize packageSize);

}
