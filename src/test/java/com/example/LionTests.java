package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public  class LionTests {
    @Test
    void maleLionHasMane() throws Exception {
        Feline feline = mock(Feline.class);
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void femaleLionNoMane() throws Exception {
        Feline feline = mock(Feline.class);
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void invalidSexThrowsException() {
        Feline feline = mock(Feline.class);
        Exception exception = assertThrows(Exception.class, () -> new Lion("Другой", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void getKittensDelegatesToFeline() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", feline);
        assertEquals(3, lion.getKittens());
    }

    @Test
    void getFoodDelegatesToFeline() throws Exception {
        Feline feline = mock(Feline.class);
        List<String> food = List.of("Мясо", "Птица");
        when(feline.getFood("Хищник")).thenReturn(food);

        Lion lion = new Lion("Самец", feline);
        assertEquals(food, lion.getFood());
        verify(feline).getFood("Хищник");
    }
}
