package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CatTest {

    private Predator fakeFeline;
    private Cat cat;

    @Before
    public void setUp() {
        fakeFeline = Mockito.mock(Feline.class);
        cat = new Cat((Feline) fakeFeline);
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFoodWithMock() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(fakeFeline.eatMeat()).thenReturn(expected);
        assertEquals(expected, cat.getFood());
    }
}