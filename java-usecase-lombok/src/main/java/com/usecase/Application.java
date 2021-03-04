package com.usecase;

import com.usecase.hr.service.price.Price;
import com.usecase.hr.service.price.PriceCodes;
import com.usecase.hr.service.rental.Movie;
import com.usecase.hr.service.rental.Rental;
import lombok.extern.java.Log;

//@SneakyThrows
@Log
public class Application {

    public static void main(String[] args) {
        log.info("Application.main()");

        System.out.println(buildRegularRental());
        System.out.println(buildNewRental());
        System.out.println(buildChildRental());
    }

    private static Rental buildRegularRental() {
        Movie movie = Movie.builder()
                .title("Titanic Regular")
                .price(Price.build(PriceCodes.REGULAR))
                .build();

        return Rental.builder()
                .movie(movie)
                .daysRented(7)
                .build();
    }

    private static Rental buildNewRental() {
        Movie movie = Movie.builder()
                .title("Titanic New")
                .price(Price.build(PriceCodes.NEW_RELEASE))
                .build();

        return Rental.builder()
                .movie(movie)
                .daysRented(7)
                .build();
    }

    private static Rental buildChildRental() {
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
