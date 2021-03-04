package com.usecase.customer.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonSerialize
public class Customer {
    private Integer id;
    private String name;
    private Integer age;
}
