package javax.lang.annotation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AnnotationInfo {

    private AnnotationInfo() {

    }

    public static Optional<Entity> getTableAnnotation(Class<?> clazz) {
        Entity table = clazz.getDeclaredAnnotation(Entity.class);

        return Optional.ofNullable(table);
    }

    public static Optional<Entity> getTableAnnotation() {
        Class<?> clazz = DBEntity.class;
        Entity table = clazz.getAnnotation(Entity.class);

        return Optional.of(table);
    }

    public static Map<String, Column> getColumnAnnotations(Class<?> clazz) {

        return getColumnMap(clazz);
    }

    public static Map<String, Column> getColumnAnnotations() {
        Class<?> clazz = DBEntity.class;

        return getColumnMap(clazz);
    }

    public static Map<String, Column> getColumnAnnotationsOfSuper(Class<?> clazz) {

        return getColumnMap(clazz.getSuperclass());
    }

    private static Map<String, Column> getColumnMap(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        Map<String, Column> map = new HashMap<>();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                map.put(field.getName(), column);
            }
        }

        return map;
    }
}
