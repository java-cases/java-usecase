package com.usecase.gson;

import com.usecase.model.Person;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SerializationTest {

    @Test
    public void toJson() {
        Person person = new Person("lee", "ken");
        Optional<String> json = Serialization.toJson(person);

        assertTrue(json.isPresent());
        System.out.println(json.get());
    }

    @Test
    public void fromJson() {
        Person person = new Person("lee", "ken");
        Optional<String> json = Serialization.toJson(person);
        assertTrue(json.isPresent());

        Optional<Person> obj = Serialization.fromJson(json.get(), Person.class);
        assertTrue(obj.isPresent());

        assertEquals(person, obj.get());

    }

    @Test
    public void normalize() {
        Person person = new Person("<script>lee</script>", "ken");
        Optional<String> json = Serialization.toJson(person);

        assertTrue(json.isPresent());
        System.out.println(Serialization.normalize(json.get()));
    }
}