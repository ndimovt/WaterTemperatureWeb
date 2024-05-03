package io.github.ndimovt.water_temp_web;

import io.github.ndimovt.water_temp_web.entity.Human;
import org.junit.Test;

import static com.mongodb.assertions.Assertions.assertFalse;
import static org.junit.Assert.assertEquals;

public class HumanTest {
    private Human h;
    @Test
    public void constructorTest(){
        h = new Human("user","pass", "name1","name2");
        assertEquals("user",h.getUsername());
        assertEquals("pass",h.getPassword());
        assertEquals("name1",h.getName());
        assertEquals("name2",h.getSurname());
    }
    @Test
    public void noArgConstructorTest(){
        h = new Human();
        assertFalse(h == null);
    }
    @Test
    public void twoArgsConstructorTest(){
        h = new Human("name1", "surname1");
        assertEquals("name1",h.getName());
        assertEquals("surname1",h.getSurname());
    }

}
