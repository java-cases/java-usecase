package com.usecase.lang;

import com.google.common.base.Preconditions;
import com.usecase.model.Employee;

import java.util.Objects;

public class ArgumentPassByValue {

    public static void test() {
        Employee e = new Employee(1);
        Employee newEmployee = assignNewObject(e);

        newEmployee.setNumber(2);

        Preconditions.checkState(e.getNumber() == 1);
        Preconditions.checkState(newEmployee.getNumber() == 2);

        Preconditions.checkState(!newEmployee.equals(e));

        modifyField(e, 3);
        Preconditions.checkState(e.getNumber() == 3);
        Preconditions.checkState(newEmployee.getNumber() == 2);
    }

    public static void modifyField(Employee e, int newNumber) {
        Objects.requireNonNull(e);

        //如果在方法中改变对象的字段值会改变原对象该字段值，因为改变的是同一个地址指向的内容。
        e.setNumber(newNumber);
    }

    public static Employee assignNewObject(Employee e) {

        //参数是以值传递的形式传入方法中，而不是引用传递。
        //将对象的地址以值的方式传递到形参中，在方法改变形参所指向对象的地址时对实参没有影响。
        e = new Employee(0);
        return e;
    }
}
