package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Book book = new Book();
    }

    @Test
    public void shouldUseEquals() {
        Book book1 = new Book(2, "Тревожные люди", 244, "Фредрик Бакман");
        Book book2 = new Book(2, "Тревожные люди", 244, "Фредрик Бакман");

        assertEquals(book1, book2);
    }

}