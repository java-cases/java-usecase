package com.usecase.hr.service.price;

public class NewReleasePrice extends AbstractPrice {

    private static double getNewReleaseCharge(int daysRented) {
        if (daysRented <= 0) {
            return 0;
        }

        return daysRented * 3;
    }

    @Override
    public int getPriceCode() {
        return PriceCodes.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        return getNewReleaseCharge(daysRented);
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        if (daysRented <= 0) {
            return 0;
        }

        // add frequent renter points （累计常客积点）。
        // add bonus for a two day new release rental
        if (daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
