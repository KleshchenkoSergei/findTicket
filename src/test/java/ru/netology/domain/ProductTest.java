package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Ticket item1 = new Ticket(1, 13_000, "BAX", "DME", 240);
    Ticket item2 = new Ticket(2, 11_500, "BAX", "SVO", 240);
    Ticket item3 = new Ticket(3, 18_500, "BAX", "LED", 240);
    Ticket item4 = new Ticket(4, 10_500, "BAX", "DME", 350);

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    @Test
    public void shouldSortByPrice() {

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        Ticket[] expected = new Ticket[]{item4, item1};
        Ticket[] actual = manager.findAllSort("BAX", "DME");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPriceNoMatches() {

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAllSort("LED", "DME");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPriceEmpty() {

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAllSort("BAX", "DME");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPriceEmptySearch() {

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAllSort("", "");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

}