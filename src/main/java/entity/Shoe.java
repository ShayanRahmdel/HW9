package entity;

import base.entity.BaseEntity;

public class Shoe extends BaseEntity<Integer> {

    private ShoesProduct shoesProduct;


    private double prize;

    private int stock;

    public Shoe(Integer integer, ShoesProduct shoesProduct, double prize, int stock) {
        super(integer);
        this.shoesProduct = shoesProduct;
        this.prize = prize;
        this.stock = stock;
    }

    public Shoe(ShoesProduct shoesProduct, double prize, int stock) {
        this.shoesProduct = shoesProduct;
        this.prize = prize;
        this.stock = stock;
    }

    public ShoesProduct getShoesProduct() {
        return shoesProduct;
    }

    public void setShoesProduct(ShoesProduct shoesProduct) {
        this.shoesProduct = shoesProduct;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "id=" + getId() +
                "shoesProduct=" + shoesProduct +
                ", prize=" + prize +
                ", stock=" + stock +
                '}';
    }
}
