package com.demo.domain;

//import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

public class Employee {

    //@ApiModelProperty(value="ID，主键", hidden=false, notes="主键，隐藏", required=true, dataType="Long")
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //@ApiModelProperty(value="员工名称")
    private String name;

    //@ApiModelProperty(value="员工年龄")
    private Integer age;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Employee() {

    }

    public Employee(Integer id, String name, Integer age) {
        this.setId(id);
        this.setName(name);
        this.setAge(age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(age, employee.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
