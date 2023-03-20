package org.shipping;

import org.shipping.service.Transaction;
import org.shipping.util.Reader;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.shipping.service.PackageSize.S;

public class App {
    public static void main(String[] args) {

        double lowestLP = 1.50;
        double limit = 10.00;
        //each 3 LP shipping per month is free
        int freeLPShippingPerMoth = 3;


        List<Transaction> inputData = Reader.readFile("src/test/resources/input.txt").stream().map(Transaction::new).toList();



    }

    public List<Transaction> applyFirstRule(List<Transaction> transactions) {
        Map<String, Double> lowestPricesBySize = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getPackageSize,
                        Collectors.mapping(Transaction::getPrice, Collectors.minBy(Double::compare))
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().orElseThrow(IllegalStateException::new)
                ));

        return transactions.stream()
                .map(shipment -> shipment.withPrice(lowestPricesBySize.get(shipment.getSize())))
                .collect(Collectors.toList());
    }

    String getSome() {
        System.out.println("Hello ");
    }


}
