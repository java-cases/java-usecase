package com.usecase.hr.service.rental;

import com.usecase.hr.service.price.Price;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"title", "price"}, exclude = {})
public class Movie {

    @Getter
    private String title;

    @Getter
    private Price price;

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}