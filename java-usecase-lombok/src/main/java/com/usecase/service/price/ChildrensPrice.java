package com.usecase.service.price;

public class ChildrensPrice extends AbstractPrice {

    private static double getChildrenCharge(int daysRented) {
        if (daysRented <= 0) {
            return 0;
        }

        double amount = 1.5;

        if (daysRented > 3) {
            amount += (daysRented - 3) * 1.5;
        }

        return amount;
    }

    /**
     * getPriceCode.
     *
     * @return
     */
    @Override
    public int getPriceCode() {
        return PriceCodes.CHILDRENS;
    }

    /**
     * getCharge.
     *
     * @param daysRented
     * @return
     */
    @Override
    public double getCharge(int daysRented) {
        return getChildrenCharge(daysRented);
    }
}
