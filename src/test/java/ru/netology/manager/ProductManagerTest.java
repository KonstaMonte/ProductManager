package ru.netology.manager;

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

    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    public void addProduct() {
        manager.add(first);
        assertArrayEquals(new Product[]{first}, repository.findAll());
    }

    @Test
    public void searchByName() {
        setUp();

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Вторая жизнь Уве");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchMatchesNameBook() {
        setUp();

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Мы начинаем в конце");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchMatchesAuthor() {
        setUp();

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Крис Уитакер");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchMatchesManufacture() {
        setUp();

        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchMatchesNameSmartphone() {
        setUp();

        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("11T");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAllBooksByAuthor() {
        setUp();

        Product[] expected = new Product[]{first,second};
        Product[] actual = manager.searchBy("Фредрик Бакман");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAll() {
        setUp();

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(null);
        assertArrayEquals(expected, actual);
    }
}