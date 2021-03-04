package com.usecase.hr.service.rental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    @Test
    public void newCustomer() {
        buildCustomer();
    }

    private Customer buildCustomer() {
        Customer customer = new Customer("John");

        customer.addRental(RentalInstances.buildRegularRental());
        customer.addRental(RentalInstances.buildNewRental());
        customer.addRental(RentalInstances.buildChildRental());

        return customer;
    }

    @Test
    public void printStatement() {
        Customer customer = buildCustomer();

        String result = customer.statement();
        System.out.println(result);
    }

    @Test
    public void statement() {
        Customer customer = buildCustomer();

        String result = customer.statement();

        String expected = "Rental Record for John" +
                "\n\tTitanic Regular	9.5" +
                "\n\tTitanic New	21.0" +
                "\n\tTitanic Child	7.5" +
                "\nAmount owed is 38.0" +
                "\nYou earned 4 frequent renter points";

        assertEquals(expected, result);
    }

    @Test
    public void printHtmlStatement() {
        Customer customer = buildCustomer();

        String result = customer.htmlStatement();
        System.out.println(result);
    }

    @Test
    public void htmlStatement() {
        Customer customer = buildCustomer();

        String result = customer.htmlStatement();

        String expected = "<H1>Rentals for <EM>John</EM></ H1><P>" +
                "\nTitanic Regular: 9.5<BR>" +
                "\nTitanic New: 21.0<BR>" +
                "\nTitanic Child: 7.5<BR>" +
                "\n<P>You owe <EM>38.0</EM><P>" +
                "\nOn this rental you earned <EM>4</EM> frequent renter points<P>";

        assertEquals(expected, result);
    }
}