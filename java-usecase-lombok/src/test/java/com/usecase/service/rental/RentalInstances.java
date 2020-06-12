package com.usecase.service.rental;

import com.usecase.service.price.Price;
import com.usecase.service.price.PriceCodes;

public class RentalInstances {

    public static Rental buildRegularRental() {
        Movie movie = Movie.builder()
                .title("Titanic Regular")
                .price(Price.build(PriceCodes.REGULAR))
                .build();

        return Rental.builder()
                .movie(movie)
                .daysRented(7)
                .build();
    }

    public static Rental buildNewRental() {
        Movie movie = Movie.builder()
                .title("Titanic New")
                .price(Price.build(PriceCodes.NEW_RELEASE))
                .build();

        return Rental.builder()
                .movie(movie)
                .daysRented(7)
                .build();
    }

    public static Rental buildChildRental() {
        Movie movie = Movie.builder()
                .title("Titanic Child")
                .price(Price.build(PriceCodes.CHILDRENS))
                .build();

        return Rental.builder()
                .movie(movie)
                .daysRented(7)
                .build();
    }
}
