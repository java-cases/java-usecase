package com.usecase.hr.service.price;

public interface Price {
    static Price build(int priceCode) {
        switch (priceCode) {
            case PriceCodes.REGULAR:
                return new RegularPrice();
            case PriceCodes.NEW_RELEASE:
                return new NewReleasePrice();
            case PriceCodes.CHILDRENS:
                return new ChildrensPrice();
            default:
                throw new IllegalArgumentException("Illegal Price Code");
        }
    }

    /**
     * 价格编码。
     *
     * @return
     */
    int getPriceCode();

    /**
     * 计算给定租赁天数的总金额。
     *
     * @param daysRented 租赁天数。
     * @return
     */
    double getCharge(int daysRented);

    /**
     * 计算给定租赁天数的总积分。
     *
     * @param daysRented
     * @return
     */
    int getFrequentRenterPoints(int daysRented);
}
