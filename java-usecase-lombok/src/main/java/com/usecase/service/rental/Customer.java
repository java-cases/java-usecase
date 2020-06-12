package com.usecase.service.rental;

import lombok.*;

import java.util.Enumeration;
import java.util.Vector;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"name"}, exclude = {})
public class Customer {

    private final Vector<Rental> rentals = new Vector<>(); // 租借记
    @Getter
    private String name; // 姓名

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String statement() {
        Enumeration<Rental> rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement(); // 取得一笔租借记。

            // show figures for this rental（显示此笔租借记录）
            result.append("\t")
                    .append(each.getMovie().getTitle())
                    .append("\t")
                    .append(String.valueOf(each.getCharge()))
                    .append("\n");
        }

        // add footer lines（结尾打印）
        result.append("Amount owed is ")
                .append(String.valueOf(getTotalCharge()))
                .append("\n")
                .append("You earned ")
                .append(String.valueOf(getTotalFrequentRenterPoints()))
                .append(" frequent renter points");

        return result.toString();
    }

    public String htmlStatement() {
        Enumeration<Rental> rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("<H1>Rentals for <EM>" + getName() + "</EM></ H1><P>\n");

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // show figures for each rental
            result.append(each.getMovie().getTitle())
                    .append(": ")
                    .append(String.valueOf(each.getCharge()))
                    .append("<BR>\n");
        }

        // add footer lines
        result.append("<P>You owe <EM>")
                .append(String.valueOf(getTotalCharge()))
                .append("</EM><P>\n")
                .append("On this rental you earned <EM>")
                .append(String.valueOf(getTotalFrequentRenterPoints()))
                .append("</EM> frequent renter points<P>");

        return result.toString();
    }

    private double getTotalCharge() {
        // 总消费金。
        return rentals.stream()
                .mapToDouble(x -> ((Rental) x).getCharge())
                .reduce(Double::sum).orElse(0);
    }

    private int getTotalFrequentRenterPoints() {
        // 常客积点
        return rentals.stream()
                .mapToInt(x -> ((Rental) x).getFrequentRenterPoints())
                .reduce(Integer::sum).orElse(0);
    }

}
