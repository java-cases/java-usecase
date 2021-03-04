package com.usecase.hr.service.price;

public abstract class AbstractPrice implements Price {

    @Override
    public abstract int getPriceCode();

    @Override
    public abstract double getCharge(int daysRented);

    /**
     * getFrequentRenterPoints.
     *
     * @param daysRented
     * @return
     */
    @Override
    public int getFrequentRenterPoints(final int daysRented) {
        if (daysRented <= 0) {
            return 0;
        }

        return 1;
    }

    @Override
    public String toString() {
        return "Price(priceCode=" + getPriceCode() + ")";
    }
}
