package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    @Test
    public void shouldUseEquals() {
        Product first = new Product(1, "Kaspersky" +
                "Anti-Virus", 20_000);
        Product second = new Product(1, "Kaspersky" +
                "Anti-Virus", 20_000);
        assertEquals(first, second);
    }

}