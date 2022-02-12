package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Product first = new Book(1, "Тревожные люди", 244, "Фредрик Бакман");
    Product second = new Book(2, "Вторая жизнь Уве", 400, "Фредрик Бакман");
    Product third = new Smartphone(3, "10XR", 45_000, "Apple");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    void shouldremoveByIdIfProductWithIdExist() {
        repository.removeById(2);
        Product[] expected = new Product[]{first, third};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldThrowNotFoundExeptionIfProductWithIdNotExist() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(7);
        });
    }

}