package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product first = new Book(1, "Тревожные люди", 244, "Фредрик Бакман");
    Product second = new Book(2, "Вторая жизнь Уве", 400, "Фредрик Бакман");
    Product third = new Book(3, "Мы начинаем в конце", 1000, "Крис Уитакер");
    Product fourth = new Smartphone(4, "Iphone", 80_000, "Apple");
    Product fifth = new Smartphone(5, "11T", 80_000, "Xiaomi");
    Product sixth = new Smartphone(8, "X10", 100_000, "Apple");

    @BeforeEach
    public void installation() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

    }

    @Test
    void SearchByBookTitleNoBook() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Тестирование");
        assertArrayEquals(expected, actual);
    }

    @Test
    void SearchByBookTitle() {
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Вторая жизнь Уве");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchForBooksByAuthor() {
        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Крис Уитакер");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchForAllBooksByAuthor() {
        Product[] expected = new Product[]{first, second};
        Product[] actual = manager.searchBy("Фредрик Бакман");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchNotAllBooksByAuthor() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Савин");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneModelNameNotModel() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("11Pro");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneModelName() {
        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Iphone");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneManufacturer() {
        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchAllBySmartphoneManufacturer() {
        Product[] expected = new Product[]{fourth, sixth};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneNotManufacturer() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

}
