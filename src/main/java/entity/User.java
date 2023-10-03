package entity;

import base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;


public class User extends BaseEntity<Integer> {
    private String firstName;
    private String lastName;

    private String userName;

    private String password;

    private String postalCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    public User(Integer integer, String firstName, String lastName, String userName, String password, String postalCode) {
        super(integer);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.postalCode = postalCode;
    }

    public User(String firstName, String lastName, String userName, String password, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.postalCode = postalCode;

    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + postalCode + '\'' +
                '}';
    }
}
