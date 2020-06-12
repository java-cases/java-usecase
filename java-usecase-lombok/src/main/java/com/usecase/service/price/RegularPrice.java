package com.usecase.service.price;

public class RegularPrice extends AbstractPrice {

    private static double getRegularCharge(int daysRented) {
        if (daysRented <= 0) {
            return 0;
        }

        double amount = 2;

        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }

        return amount;
    }

    @Override
    public int getPriceCode() {
        return PriceCodes.REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
        return getRegularCharge(daysRented);
    }
}
