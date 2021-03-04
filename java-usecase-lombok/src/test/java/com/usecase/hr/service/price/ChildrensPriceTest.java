package com.usecase.hr.service.price;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ChildrensPriceTest {

    private Price price = new ChildrensPrice();

    @BeforeAll
    public static void init() {
    }

    @AfterAll
    public static void cleanup() {
    }

    @BeforeEach
    public void tearup() {
    }

    @AfterEach
    public void tearDown() {
    }

    @DisplayName("test getPriceCode")
    @Test
    public void getPriceCode() {
        assertEquals(PriceCodes.CHILDRENS, price.getPriceCode());
    }

    @Test
    public void getChargeDaysRentedLessThan0() {
        assertAll(() -> assertThat(price.getCharge(-100), CoreMatchers.equalTo(0.0)),
                () -> assertThat(price.getCharge(0), CoreMatchers.equalTo(0.0)));
    }

    @Test
    public void getChargeDaysRentedLessThan3() {
        assertThat(price.getCharge(1), CoreMatchers.equalTo(1.5));

        assertThat(price.getCharge(2), CoreMatchers.equalTo(1.5));

        assertThat(price.getCharge(3), CoreMatchers.equalTo(1.5));
    }

    @Test
    public void getChargeDaysRentedMoreThan3() {
        assertThat(price.getCharge(4), CoreMatchers.equalTo(3.0));

        assertThat(price.getCharge(5), CoreMatchers.equalTo(4.5));
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