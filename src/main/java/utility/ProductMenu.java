package utility;

import entity.Electronic;
import entity.ElectronicProduct;
import entity.Order;
import entity.Shoe;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductMenu {
    private final Scanner input = new Scanner(System.in);
    ApplicationContext applicationContext = new ApplicationContext();


    public void StoreMenu() throws SQLException {
        System.out.println("1_Look All Product");
        System.out.println("2_order the Product");
        System.out.println("3_See Your Cart");
        int select = giveIntegerInput();
        switch (select) {
            case 1 -> loadProduct();
            case 2 -> orderProduct();
            default -> System.out.println("sdasd");
        }

    }

    private Integer giveIntegerInput() {
        int i;
        while (true) {
            try {
                i = input.nextInt();
                input.nextLine();
                return i;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Enter just number Please");
            }
        }
    }

    private void loadProduct() throws SQLException {
        System.out.println("================ Electronic Items ==================");
        List<Electronic> items = applicationContext.getElectronicService().findAll();
        System.out.println(items);
        System.out.println();
        System.out.println("================Shoes Items ======================");
        List<Shoe> shoes = applicationContext.getShoeService().findAll();
        System.out.println(shoes);
    }

    private void orderProduct() throws SQLException {
        System.out.print("Enter user id: ");
        int userId = chechUserID();

        System.out.print("Enter Electronic id: ");
        int elecID = checkElectronicStock();
        System.out.print("Enter Shoe id ");
        int shoeID = checkShoesStock();

        Order order = new Order(userId, elecID, shoeID);
        applicationContext.getShoeService().decreaseItem(shoeID);
        applicationContext.getElectronicService().decreaseItem(elecID);
        applicationContext.getOrderService().save(order);
    }

    private int chechUserID() throws SQLException {
        int userId = 0;
        boolean flag = true;
        while (flag) {
            userId = giveIntegerInput();
            if (applicationContext.getUserService().findUserId(userId)) {
                flag = false;
            } else System.out.println("Your ID is wrong please try again");
        }
        return userId;
    }

    private int checkShoesStock() throws SQLException {
        int shoeID = 0;
        boolean flag = true;
        while (flag) {
            shoeID = giveIntegerInput();
            if (applicationContext.getShoeService().checkStock(shoeID)) {
                System.out.println("Your stock is empty");
            } else flag = false;
        }
        return shoeID;
    }

    private int checkElectronicStock() throws SQLException {
        int elecID = 0;
        boolean flag = true;
        while (flag) {
            elecID = giveIntegerInput();
            if (applicationContext.getElectronicService().checkStock(elecID)) {
                System.out.println("Your stock is empty");
            } else flag = false;
        }
        return elecID;
    }
}
