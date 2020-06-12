package com.usecase.lang.annotation;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class AnnotationInfoTest {

    @Test
    public void getTableAnnotation() {
        Optional<Entity> optional = AnnotationInfo.getTableAnnotation();
        Assert.assertTrue(optional.isPresent());

        Entity table = optional.get();
        System.out.println(table);

        Assert.assertNotNull(table);
        Assert.assertEquals("t_entity", table.name());
        Assert.assertEquals("id", table.key());
    }

    @Test
    public void getTableAnnotationWithClazz() {
        Optional<Entity> optional = AnnotationInfo.getTableAnnotation(DBEntity.class);
        Assert.assertTrue(optional.isPresent());

        optional = AnnotationInfo.getTableAnnotation(AnnotationInfo.class);
        Assert.assertFalse(optional.isPresent());
    }

    @Test
    public void getColumnAnnotations() {
        Map<String, Column> map = AnnotationInfo.getColumnAnnotations(DBEntityExt.class);
        System.out.println(map);
        Assert.assertNotNull(map);

        Assert.assertEquals("name", map.get("name").name());
        Assert.assertEquals("age", map.get("age").name());
        Assert.assertEquals("birthday", map.get("birthday").name());
    }

    @Test
    public void getColumnAnnotationsOfSuper() {
        Map<String, Column> map = AnnotationInfo.getColumnAnnotationsOfSuper(DBEntityExt.class);
        System.out.println(map);
        Assert.assertNotNull(map);

        Assert.assertEquals("id", map.get("id").name());
        Assert.assertEquals(false, map.get("id").autoIncrement());
        Assert.assertEquals(false, map.get("id").nullable());
        assertEquals(ColumnType.VARCHAR, map.get("id").type());
    }

    @Test
    public void getColumnAnnotationsWithClazz() {
        Map<String, Column> map = AnnotationInfo.getColumnAnnotations(DBEntity.class);
        Assert.assertNotNull(map);
        Assert.assertTrue(map.size() > 0);

        map = AnnotationInfo.getColumnAnnotations(AnnotationInfo.class);
        Assert.assertNotNull(map);
        Assert.assertTrue(map.size() == 0);
    }
}