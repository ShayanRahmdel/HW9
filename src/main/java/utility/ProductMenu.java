package utility;

import entity.Electronic;
import entity.ElectronicProduct;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductMenu {
    private final Scanner input = new Scanner(System.in);
    ApplicationContext applicationContext = new ApplicationContext();


    public void StoreMenu() throws SQLException {
        System.out.println("1_Look All Product");
        System.out.println("2_buy the Product");
        System.out.println("3_See Your Cart");
        int select = giveIntegerInput();
        switch(select){
            case 1 -> loadProduct();
            case 2-> System.out.println("asd");
            default -> System.out.println("sdasd");
        }

    }
    private Integer giveIntegerInput(){
        int i;
        while (true){
            try {
                i=input.nextInt();
                input.nextLine();
                return i;
            }
            catch (InputMismatchException e){
                input.nextLine();
                System.out.println("Enter just number Please");
            }
        }
    }

    private void loadProduct() throws SQLException {
       List<Electronic> items =  applicationContext.getElectronicService().findAll();
        System.out.println(items);
    }
}
