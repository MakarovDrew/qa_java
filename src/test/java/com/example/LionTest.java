package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
public class LionTest {

    private Feline fakeFeline;

    @Before
    public void setUp() {
        fakeFeline = Mockito.mock(Feline.class);
    }

    @Test
    public void testGetKittensWithMock() throws Exception {
        Mockito.when(fakeFeline.getKittens()).thenReturn(2);
        Lion lion = new Lion("Самка", fakeFeline);
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void testGetFoodWithMock() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(fakeFeline.getFood("Хищник")).thenReturn(expected);
        Lion lion = new Lion("Самец", fakeFeline);
        assertEquals(expected, lion.getFood());
    }

    @Test
    public void testExceptionInvalidSex() {
        Exception thrown = assertThrows(Exception.class,
                () -> new Lion("Небинарный", new Feline()));

        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                thrown.getMessage());
    }
    @Test
    public void testHasMane() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        assertTrue(lion.doesHaveMane());
    }
}