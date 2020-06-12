package com.usecase.lang.annotation;

import java.util.Date;

@EntityExt(name = "t_entity_ext", key = "parent_id")
public class DBEntityExt extends DBEntity{

    @Column(name = "parent_id", type = ColumnType.VARCHAR, nullable = false, autoIncrement = false)
    String parentId;

    @Column(name = "name", type = ColumnType.VARCHAR, nullable = false)
    String name;

    @Column(name = "age", type = ColumnType.INT)
    int age;

    @Column(name = "birthday", type = ColumnType.DATE)
    Date birthday;


}
