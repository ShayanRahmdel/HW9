package entity;

import base.entity.BaseEntity;

public class Product extends BaseEntity<Integer> {

    private String name;

    private double price;

    private int stock;


    private Category category;

    public Product(Integer integer, String name, double price, int stock, Category category) {
        super(integer);
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public Product(String name, double price, int stock, Category category) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id="+ getId()+" "+
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", category=" + category +
                '}';
    }
}
