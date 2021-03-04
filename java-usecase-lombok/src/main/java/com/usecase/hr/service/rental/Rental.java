package com.usecase.hr.service.rental;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"movie", "daysRented"}, exclude = {})
public class Rental {

    @Getter
    private Movie movie; // 影片

    @Getter
    private int daysRented; // 租期

    public double getCharge() {
        return movie.getCharge(this.getDaysRented());
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(this.getDaysRented());
    }

}
