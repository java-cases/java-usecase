package com.usecase.hr.model;

import java.util.Arrays;

public enum Season {
    SPRING("spring", 1),
    SUMMER("summer", 2),
    AUTUMN("autum", 3),
    WINTER("winter", 4);

    private final String label;
    private final int value;

    Season(String label, int value) {
        this.label = label;
        this.value = value;
    }

    public static Season of(int value) {
        return Arrays.stream(Season.values())
                .filter(x -> x.value == value)
                .findFirst()
                .orElse(Season.SPRING);
    }

    public static Season of(String label) {
        return Arrays.stream(Season.values())
                .filter(x -> x.label == label)
                .findFirst()
                .orElse(Season.SPRING);
    }

    public String getLabel() {
        return label;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + this.name() + '\'' +
                ", label='" + label + '\'' +
                ", value=" + value +
                '}';
    }
}
