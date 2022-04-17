package ru.netology.repository;

import ru.netology.domain.Ticket;

public class ProductRepository {

    private Ticket[] items = new Ticket[0];

    public ProductRepository() {
    }

    public void save(Ticket item) {
        int length = items.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public void removeById(int id) {
        int index = 0;
        Ticket[] tmp = new Ticket[items.length - 1];
        for (Ticket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public Ticket[] findAll() {
        return items;
    }


}
