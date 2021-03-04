package com.usecase.guava.common;

import com.usecase.hr.model.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComparisonChainTest {

    @Test
    public void compareTo() {
        Person persion1 = new ComparableChainPerson("lastName1", "fisrtName1");
        Person persion2 = new ComparableChainPerson("lastName2", "fisrtName2");

        int r = persion1.compareTo(persion2);
        assertEquals(true, r < 0);
    }

    @Test
    public void compareToWithSameValues() {
        Person persion1 = new ComparableChainPerson("lastName", "fisrtName");
        Person persion2 = new ComparableChainPerson("lastName", "fisrtName");

        int r = persion1.compareTo(persion2);
        assertEquals(0, r);
    }
}
