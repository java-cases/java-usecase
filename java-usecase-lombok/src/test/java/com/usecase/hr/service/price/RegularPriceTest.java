package com.usecase.hr.service.price;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegularPriceTest {

    private Price price = new RegularPrice();

    @Test
    public void getPriceCode() {
        assertEquals(PriceCodes.REGULAR, price.getPriceCode());
    }

    @Test
    public void getChargeDaysRentedLessThan0() {
        assertThat(price.getCharge(-100), CoreMatchers.equalTo(0.0));

        assertThat(price.getCharge(0), CoreMatchers.equalTo(0.0));
    }

    @Test
    public void getChargeDaysRentedLessThan2() {
        assertThat(price.getCharge(1), CoreMatchers.equalTo(2.0));

        assertThat(price.getCharge(2), CoreMatchers.equalTo(2.0));


    }

    @Test
    public void getChargeDaysRentedMoreThan2() {
        assertThat(price.getCharge(3), CoreMatchers.equalTo(3.5));
    }

    @Test
    public void getFrequentRenterPointsLessThan0() {
        assertThat(price.getFrequentRenterPoints(-100), CoreMatchers.equalTo(0));

        assertThat(price.getFrequentRenterPoints(0), CoreMatchers.equalTo(0));
    }

    @Test
    public void getFrequentRenterPointsMoreThan0() {
        assertThat(price.getFrequentRenterPoints(1), CoreMatchers.equalTo(1));

        assertThat(price.getFrequentRenterPoints(2), CoreMatchers.equalTo(1));
    }
}