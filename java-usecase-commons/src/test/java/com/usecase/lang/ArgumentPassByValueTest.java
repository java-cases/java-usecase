package com.usecase.lang;

import com.usecase.hr.model.Employee;
import org.junit.Assert;
import org.junit.Test;

public class ArgumentPassByValueTest {

    @Test
    public void test() {
        ArgumentPassByValue.test();
    }

    @Test
    public void modifyField() {
        Employee e = new Employee(1);
        ArgumentPassByValue.modifyField(e, 2);

        Assert.assertEquals(2, e.getNumber());
    }

    @Test
    public void assignNewObject() {
        Employee e = new Employee(1);
        Employee newEmployee = ArgumentPassByValue.assignNewObject(e);
        newEmployee.setNumber(2);

        Assert.assertTrue(e != newEmployee);

        Assert.assertTrue(!e.equals(newEmployee));
    }

    @Test
    public void assignNewObjectSameNumber() {
        Employee e = new Employee(1);
        Employee newEmployee = ArgumentPassByValue.assignNewObject(e);
        newEmployee.setNumber(1);

        Assert.assertTrue(e != newEmployee);

        Assert.assertTrue(e.equals(newEmployee));
    }

    @Test
    public void assignNewObjectNull() {
        Employee e = null;
        Employee newEmployee = ArgumentPassByValue.assignNewObject(e);
        newEmployee.setNumber(1);

        Assert.assertNull(e);
        Assert.assertNotNull(newEmployee);
    }
}