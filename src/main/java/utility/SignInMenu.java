package utility;

import java.sql.SQLException;
import java.util.Scanner;

public class SignInMenu {
    private final Scanner input = new Scanner(System.in);

    ApplicationContext applicationContext = new ApplicationContext();

    private final ProductMenu productMenu = new ProductMenu();



    protected void signIn() throws SQLException {
        System.out.print("enter your userName: ");
        String userName = validUserName();
        System.out.print("enter your password: ");
        String password = validPassword();
        System.out.println("Successful register");
        System.out.println();
        productMenu.StoreMenu();
    }

    private String validPassword() throws SQLException {
        String password="";
        boolean flag = true;
        while (flag){
            password =input.next();
            if (applicationContext.getUserService().rightPassword(password)){
                flag=false;
            }else System.out.println("your password is incorrect");
        }
        return password;
    }

    private String validUserName() throws SQLException {
        String userName=" ";
        boolean flag = true;
        while (flag) {
             userName = input.next();
            if (applicationContext.getUserService().rightUserName(userName)){
                flag =false;
            }else System.out.println("your user is incorrect");
        }
        return userName;
    }


}
