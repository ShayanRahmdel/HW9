package utility;

import entity.User;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuApp {

    private final Scanner input = new Scanner(System.in);

    ApplicationContext applicationContext = new ApplicationContext();




    public void menu() throws SQLException {
        System.out.println("Welcome to online store");
        System.out.println("1_sign up");
        System.out.println("2_sign in");
        System.out.println("3_exit");
        int select = giveIntegerInput();
        switch (select){
            case 1->signUp();
            case 2-> System.out.println("sign in");
            default -> System.out.println("exit");
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

    private void signUp() throws SQLException {
        System.out.print("enter your firstName: ");
        String firstName = input.next();
        System.out.print("enter your lastName: ");
        String lastName = input.next();
        System.out.print("enter your userName: ");
        String userName =  userValidation();
        System.out.print("enter your password: ");
        String password = validPassword();
        System.out.print("enter your postalCode: ");
        String postalCode = validPostalCode();
        User user = new User(firstName,lastName,userName,password,postalCode);
        applicationContext.getUserService().save(user);
        System.out.println("successful sign Up");
    }

    private String validPostalCode() {
        String postalCode=" ";
        boolean flag = true;
        while (flag){
             postalCode = input.next();
            if (Validation.isValidPostalCode(postalCode)){
                flag = false;
            }else System.out.println("enter valid postalCode");
        }
        return postalCode;
    }

    private String validPassword() {
        String password = " ";
        boolean flag = true;
        while (flag){
             password = input.next();
            if (Validation.isValidPassword(password)){
                flag = false;
            }else System.out.println("enter valid password");
        }
        return password;
    }

    private String userValidation() {
        String userName=" ";
        boolean flag = true;
        while (flag){
             userName = input.next();
            if (Validation.isValidUserName(userName)){
                flag = false;
            }else System.out.println("enter valid userName");
        }
        return userName;
    }


}
