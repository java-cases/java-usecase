package com.usecase.hr.model;

import lombok.*;


@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "name"})
@ToString(of = {"id", "name"}, exclude = {"age"})
public class Employee {

    @NonNull
    private Integer id;

    @NonNull
    private String name;
    private Integer age;
}
