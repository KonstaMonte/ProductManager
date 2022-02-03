package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();
    Product first = new Book(1, "Тревожные люди", 244, "Фредрик Бакман");
    Product second = new Book(2, "Вторая жизнь Уве", 400, "Фредрик Бакман");

    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExists() {
        repository.save(first);

        int idToRemove=1;
        repository.removeById(idToRemove);

        Product[] expected = new Product[] {};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }
}