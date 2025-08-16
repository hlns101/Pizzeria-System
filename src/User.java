import java.util.Scanner;

public class User {
    private String name;
    private String password;
    String role;

    User(){

    }
    User(String name, String password, String role){
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public void menu() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome " + getName());
            System.out.println("1. View Pizzeria Menu ");
            System.out.println("2. Place Order ");
            System.out.println("3. Logout ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                viewItems();
                menu();
            } else if (choice == 2) {
                placeOrder();
            } else {
                logout();
            }
        } catch (Exception e){
            System.out.println("Error. Please choose from 1-3");
            menu();
        }

    }

    public void viewItems(){
        Pizza pizza = new Pizza();
        pizza.pizzaMenu();
        menu();
    }

    public void placeOrder(){
        Customer newCustomer = new Customer(name, password, "Customer");
        newCustomer.placeOrder(1);
    }

    public void logout(){
        System.out.println("Logging out. Thank you!");
        Main.loginMenu();
    }
}
