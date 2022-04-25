package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.ProductRepository;

import java.util.Arrays;

public class ProductManager {

    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductManager() {
    }

    public void add(Ticket item) {
        repository.save(item);
    }

    public Ticket[] findAllSort(String from, String to) {
        Ticket[] items = repository.findAll();
        Ticket[] result = new Ticket[0];
        for (Ticket item : items) {
            if (from.equals(item.getDeparture())) {
                if (to.equals(item.getArrival())) {

                    int length = result.length + 1;
                    Ticket[] tmp = new Ticket[length];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    int lastIndex = tmp.length - 1;
                    tmp[lastIndex] = item;
                    Arrays.sort(tmp);
                    result = tmp;
                }
            }
        }
        return result;
    }

}
