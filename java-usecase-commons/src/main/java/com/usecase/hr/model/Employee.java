package com.usecase.hr.model;

import java.util.Objects;

public class Employee implements Comparable<Employee> {

    private int number;

    public Employee(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * 判断两个对象是否相等
     */
    public boolean equals(Object obj) {

        //检查是否为同一个对象的引用，如果是直接返回 true；
        if (obj == this) {
            return true;
        }

        //检查是否是同一个类型，如果不是，直接返回 false
        if (obj != null && obj.getClass() == this.getClass()) {

            // 将 Object 对象进行转型
            Employee other = (Employee) obj;

            // 判断每个关键域是否相等。
            return this.number == other.number;
        }

        return false;
    }

    //根据 number 来计算 hashCode 值。
    public int hashCode() {
        return this.number;
    }

    @Override
    public int compareTo(Employee o) {
        Objects.requireNonNull(o);
        return Integer.compare(this.number, o.number);
    }
}
