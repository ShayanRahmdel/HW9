package entity;

import base.entity.BaseEntity;

public class Order extends BaseEntity<Integer> {


    private int userID;

    private int elecProduct_ID;

    private int shoeProduct_ID;

    public Order(Integer integer, int userID, int elecProduct_ID, int shoeProduct_ID) {
        super(integer);
        this.userID = userID;
        this.elecProduct_ID = elecProduct_ID;
        this.shoeProduct_ID = shoeProduct_ID;
    }

    public Order( int userID, int elecProduct_ID, int shoeProduct_ID) {

        this.userID = userID;
        this.elecProduct_ID = elecProduct_ID;
        this.shoeProduct_ID = shoeProduct_ID;
    }





    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getElecProduct_ID() {
        return elecProduct_ID;
    }

    public void setElecProduct_ID(int elecProduct_ID) {
        this.elecProduct_ID = elecProduct_ID;
    }

    public int getShoeProduct_ID() {
        return shoeProduct_ID;
    }

    public void setShoeProduct_ID(int shoeProduct_ID) {
        this.shoeProduct_ID = shoeProduct_ID;
    }
}
