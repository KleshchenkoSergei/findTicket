package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.ProductRepository;

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
            if ((item.getDeparture() == from) & (item.getArrival() == to)) {

                int length = result.length + 1;
                Ticket[] tmp = new Ticket[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = item;
                result = tmp;
            }
        }
        return result;
    }

}
