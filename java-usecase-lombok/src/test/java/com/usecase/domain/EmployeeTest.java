package com.usecase.domain;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class EmployeeTest {

    @Test
    void builder() {
        Employee employee = Employee.builder()
                .id(1000)
                .name("susan")
                .age(18)
                .build();

        assertThat(employee.getId(), Matchers.equalTo(1000));
        assertThat(employee.getName(), Matchers.equalTo("susan"));
        assertThat(employee.getAge(), Matchers.equalTo(18));
    }

    @Test
    void testEquals() {
        Employee entity1 = new Employee(1000, "SUSAN");
        Employee entity2 = new Employee(1000, "SUSAN");

        assertThat(entity1.equals(entity2), Matchers.is(true));
    }

    @Test
    void testHashCode() {
        Employee entity1 = new Employee(1000, "SUSAN");
        Employee entity2 = new Employee(1000, "SUSAN");

        assertThat(entity1.hashCode(), Matchers.equalTo(entity2.hashCode()));
    }

    @Test
    void testToString() {
        Employee entity1 = new Employee(1000, "SUSAN");
        Employee entity2 = new Employee(1000, "SUSAN");

        assertThat(entity1.toString(), Matchers.equalTo(entity2.toString()));
    }
}