import java.util.*;
import java.io.FileWriter;

public class UserDetails {
    private String UserName;
    private String Password;
    private String Phone;
    private int Age;

    // Get Details from user
    public void setUserDetails() {
        try {
            Scanner input = new Scanner(System.in);
            int confirmButton = 0;
            outerLoop: while (true) {
                System.err.print("Enter Your Name: ");
                String username = setDetails(input);
                System.out.print("Enter Your Age: ");
                int age = setDetails(input);
                System.out.print("Enter Your Phone: ");
                String phone = setDetails(input);
                System.out.print("Enter Your Password: ");
                String password = setDetails(input);
                System.out.print("Click 1 For Confirmation: ");
                confirmButton = setDetails(input);
                if (confirmButton == 1) {
                    // this.UserName = username;
                    // this.Phone = phone;
                    // this.Age = age;
                    // this.Password = password;
                    FileWriter StoreUserDetails = new FileWriter("UserDetails.txt");
                    StoreUserDetails.write(getFormatingData(username, phone, age, password));
                    StoreUserDetails.close();
                    System.out.println("Your Details Saved Successfully");
                    return;
                } else {
                    System.out.println("Details Discarded Successfully");
                    System.out.print("Do You Want to Continue (Y/N): ");
                    char option = setDetails(input);
                    if (option == 'Y' || option == 'y') {
                        setUserDetails();
                    }
                    return;
                }
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // create input helper
    public static <T> T setDetails(Scanner input) {
        try {
            if (input.hasNextInt()) {
                return (T) (Integer) input.nextInt();
            } else if (input.hasNextFloat()) {
                return (T) (Float) input.nextFloat();
            } else if (input.hasNext()) {
                String nextInput = input.next();
                if (nextInput.length() != 1) {
                    return (T) nextInput;
                } else {
                    return (T) (Character) nextInput.charAt(0);
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public static String getFormatingData(String name, String phone, int age, String passString) {
        return String.format("Name: %s, Phone: %s, Age: %d, Password: %s", name, phone, age, passString);
    }

}
