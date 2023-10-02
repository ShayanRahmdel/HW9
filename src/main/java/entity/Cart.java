package entity;

import base.entity.BaseEntity;

public class Cart extends BaseEntity<Integer> {
    private double totalPrize;


    private ElectronicProduct[] products;
    private ShoesProduct [] shoesProducts;
    private int userID;

    private int quantity;

}
