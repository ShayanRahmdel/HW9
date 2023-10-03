package entity;

import base.entity.BaseEntity;
import repository.ElecRepository;

public class Electronic  extends BaseEntity<Integer> {
    private ElectronicProduct electronicProduct;


    private double prize;

    private int stock;



    public Electronic(Integer integer, ElectronicProduct electronicProduct,  double prize, int stock) {
        super(integer);
        this.electronicProduct = electronicProduct;
        this.prize = prize;
        this.stock = stock;
    }

    public Electronic(Integer integer, double prize, int stock) {
        super(integer);
        this.prize = prize;
        this.stock = stock;
    }

    public Electronic( double prize, int stock) {
        this.prize = prize;
        this.stock = stock;
    }

    public Electronic(ElectronicProduct electronicProduct, double prize, int stock) {
        this.electronicProduct = electronicProduct;
        this.prize = prize;
        this.stock = stock;
    }
    public ElectronicProduct getElectronicProduct() {
        return electronicProduct;
    }

    public void setElectronicProduct(ElectronicProduct electronicProduct) {
        this.electronicProduct = electronicProduct;
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
        return "Electronic{" +
                "id=" + getId()+ "  "+
                "electronicProduct=" + electronicProduct +
                ", prize=" + prize +
                ", stock=" + stock +
                '}';
    }
}
