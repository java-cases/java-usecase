package javax.lang.annotation;

import java.util.Date;

@Entity(name = "t_entity", key = "id")
public class DBEntity {

    @Column(name = "id", type = ColumnType.VARCHAR, nullable = false, autoIncrement = false)
    String id;

    @Column(name = "created_by", type = ColumnType.VARCHAR, nullable = false)
    String createdBy;

    @Column(name = "created_time", type = ColumnType.DATE)
    Date createdTime;

}
