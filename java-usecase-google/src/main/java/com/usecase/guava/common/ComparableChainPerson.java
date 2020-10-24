package com.usecase.guava.common;

import com.google.common.collect.ComparisonChain;
import com.usecase.model.Person;

public class ComparableChainPerson extends Person {

    public ComparableChainPerson(String lastName, String firstName) {
        super(lastName, firstName);
    }

    @Override
    public int compareTo(Person other) {
        return ComparisonChain.start()
                .compare(super.getLastName(), other.getLastName())
                .compare(super.getFirstName(), other.getFirstName())
                .compare(super.getZipCode(), other.getZipCode())
                .result();
    }
}
