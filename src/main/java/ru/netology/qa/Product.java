package ru.netology.qa;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public abstract class Product {
    protected int id;
    protected String name;
    protected int price;
    public boolean matches(String search) {
        return getName().contains(search);
    }
}

