package utility;

import entity.Order;
import entity.Product;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductMenu {
    private final Scanner input = new Scanner(System.in);
    ApplicationContext applicationContext = new ApplicationContext();


    public void StoreMenu() throws SQLException {
        boolean flag = true;
        while (flag){
            System.out.println("1_Look All Product");
            System.out.println("2_add the Product in your Cart");
            System.out.println("3_remove the Product from your Cart");
            System.out.println("4_See Your Cart");
            System.out.println("5_back to user menu");
            int select = giveIntegerInput();
            switch (select) {
                case 1 -> loadProduct();
                case 2 -> orderProduct();
                case 3 -> removeProduct();
                case 4 -> showCart();
                case 5 -> flag = false;
                default -> System.out.println("enter valid number");
            }

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
        System.out.println("================  Items ==================");
        List<Product> items = applicationContext.getProductService().findAll();
        System.out.println(items);
        System.out.println();

    }

    private void orderProduct() throws SQLException {
        System.out.print("Enter userName: ");
        String userName = validUserName();
        int userId = applicationContext.getUserService().findIDByUserName(userName);
        System.out.print("Enter product id: ");
        int produtId = checkStockItem();
        Order order = new Order(userId, produtId);
        applicationContext.getOrderService().save(order);
        applicationContext.getProductService().decrease(produtId);
    }

    private int checkStockItem() throws SQLException {
        int productID = 0;
        boolean flag = true;
        while (flag) {
            productID = giveIntegerInput();

            if (applicationContext.getProductService().checkStock(productID) == 0
                    && !applicationContext.getProductService().checkId(productID)) {
                System.out.println("we dont have this item antmore or Your id is wrong  ");
            } else flag = false;
        }
        return productID;
    }


    private String validUserName() throws SQLException {
        String userName = " ";
        boolean flag = true;
        while (flag) {
            userName = input.next();
            if (applicationContext.getUserService().rightUserName(userName)) {
                flag = false;
            } else System.out.println("your user is incorrect");
        }
        return userName;
    }

    private void removeProduct() throws SQLException {
        System.out.print("Enter id Order: ");
        int productID = checkProdutID();
        applicationContext.getOrderService().deleteByProductID(productID);
        applicationContext.getProductService().increase(productID);

    }

    private int checkProdutID() throws SQLException {
        int productID=0;
        boolean flag = true;
        while (flag){
             productID = giveIntegerInput();
            if (applicationContext.getOrderService().findProductId(productID)){
                System.out.println("enter right ID");

            }else flag=false;
        }
        return productID;
    }

    private void showCart() throws SQLException {
        System.out.println("enter your ID");
        int id = giveIntegerInput();
        applicationContext.getOrderService().printCart(id);
        applicationContext.getOrderService().printTotalPrice(id);
        System.out.println();
    }


}
