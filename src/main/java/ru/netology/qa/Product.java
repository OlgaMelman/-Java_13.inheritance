package ru.netology.qa;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Product {
    protected int id;
    protected String name;
    protected int price;
}

