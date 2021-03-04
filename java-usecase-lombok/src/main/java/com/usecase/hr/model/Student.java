package com.usecase.hr.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Student {
    @NonNull
    private Integer id;

    @NonNull
    private String name;
    private Integer age;
}
