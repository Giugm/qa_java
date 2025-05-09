package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CatTests {
    @Test
    void getSoundReturnsMeow() {
        Cat cat = new Cat(mock(Feline.class));
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodReturnsFoodFromPredator() throws Exception {
        Feline mockFeline = mock(Feline.class);
        List<String> expectedFood = List.of("Мясо", "Курица");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(mockFeline);
        assertEquals(expectedFood, cat.getFood());
        verify(mockFeline).eatMeat();
    }
}
