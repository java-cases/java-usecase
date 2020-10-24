package com.usecase.model;

import com.google.common.base.Preconditions;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String lastName;
    private String firstName;
    private int zipCode;

    public Person(String lastName, String firstName) {

        checkPreconditions(lastName, firstName);

        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getZipCode() {
        return zipCode;
    }

    private void checkPreconditions(String lastName, String firstName) {

        Preconditions.checkArgument(lastName != null,
                "lastName was null but expected not null");

        Preconditions.checkArgument(firstName != null,
                "firstName was null but expected not null");
    }

    @Override
    public int compareTo(Person other) {
        int r = lastName.compareTo(other.lastName);
        if (r != 0) {
            return r;
        }

        r = firstName.compareTo(other.firstName);
        if (r != 0) {
            return r;
        }

        return Integer.compare(zipCode, other.zipCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return zipCode == person.zipCode &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(firstName, person.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, zipCode);
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
