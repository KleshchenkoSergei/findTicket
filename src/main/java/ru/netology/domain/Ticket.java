package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int flightTime;

    @Override
    public int compareTo(@NotNull Ticket o) {
        return this.price - o.price;
    }

}
