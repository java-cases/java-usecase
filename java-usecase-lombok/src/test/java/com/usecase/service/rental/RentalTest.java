package com.usecase.service.rental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RentalTest {

    @Test
    public void getChargForRegularRental() {
        Rental rental = RentalInstances.buildRegularRental();

        assertTrue(9.5 == rental.getCharge());
    }

    @Test
    public void getChargForNewRental() {
        Rental rental = RentalInstances.buildNewRental();

        assertTrue(21.0 == rental.getCharge());
    }

    @Test
    public void getChargForChildRental() {
        Rental rental = RentalInstances.buildChildRental();

        assertTrue(7.5 == rental.getCharge());
    }

    @Test
    public void getFrequentRenterPointsForRegularRental() {
        Rental rental = RentalInstances.buildRegularRental();

        assertEquals(1, rental.getFrequentRenterPoints());
    }

    @Test
    public void getFrequentRenterPointsForNewRental() {
        Rental rental = RentalInstances.buildNewRental();

        assertEquals(2, rental.getFrequentRenterPoints());
    }

    @Test
    public void getFrequentRenterPointsForChildRental() {
        Rental rental = RentalInstances.buildChildRental();

        assertEquals(1, rental.getFrequentRenterPoints());
    }
}