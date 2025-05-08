package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FelineTests {
    @Test
    void eatMeatReturnsPredatorFoodList() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        assertNotNull(food);
        assertTrue(food.contains("Животные") || food.contains("Птицы") || food.contains("Рыба"));
    }

    @Test
    void getFamilyReturnsCats() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensReturnsDefault() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    void getKittensWithParamReturnsCorrectValue() {
        Feline feline = new Feline();
        assertEquals(5, feline.getKittens(5));
    }


}
