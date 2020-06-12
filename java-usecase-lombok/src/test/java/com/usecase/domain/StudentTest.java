package com.usecase.domain;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class StudentTest {

    @Test
    void testEquals() {
        Student entity1 = new Student(1000, "SUSAN");
        Student entity2 = new Student(1000, "SUSAN");

        assertThat(entity1.equals(entity2), Matchers.is(true));
    }

    @Test
    void testHashCode() {
        Student entity1 = new Student(1000, "SUSAN");
        Student entity2 = new Student(1000, "SUSAN");

        assertThat(entity1.hashCode(), Matchers.equalTo(entity2.hashCode()));
    }

    @Test
    void testToString() {
        Student entity1 = new Student(1000, "SUSAN");
        Student entity2 = new Student(1000, "SUSAN");

        assertThat(entity1.toString(), Matchers.equalTo(entity2.toString()));
    }
}