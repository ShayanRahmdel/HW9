package entity;

import base.entity.BaseEntity;

public class Order extends BaseEntity<Integer> {


    private int userID;

    private String productName;

    private int productID;

    private double totalPrice;

    public Order(Integer integer,String productName, int stock,double totalPrice) {
        super();
        this.productName = productName;
        this.totalPrice = totalPrice;
        this.stock = stock;
    }

    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }


    public Order(Integer integer, int userID, int productID) {
        super(integer);
        this.userID = userID;
        this.productID = productID;

    }

    public Order(int userID, int productID) {
        this.userID = userID;
        this.productID = productID;

    }

    public Order(Integer integer, int userID, String productName) {
        super(integer);
        this.userID = userID;
        this.productName = productName;

    }

    public Order(int userID, String productName) {
        this.userID = userID;
        this.productName = productName;

    }

    @Override
    public String toString() {
        return "Order{" +
                "id="+ getId()+" "+
                "productName='" + productName + '\'' +
                ", totalPrice=" + totalPrice +
                ", stock=" + stock +
                '}';
    }
}
