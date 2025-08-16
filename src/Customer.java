import java.util.Scanner;

public class Customer extends User {

    Scanner scanner = new Scanner(System.in).useDelimiter("\n"); // For input to take spaces . Credit to https://stackoverflow.com/a/52621489
    Customer(){

    }

    Customer(String name, String password, String role){
        super(name, password, role);
    }

    public void menu(){
        System.out.println("1. View Pizzeria Menu");
        System.out.println("2. Place Order");
        System.out.println("3. Logout");
        System.out.println("4. Quit");
        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                viewItems();
                menu();
                break;
            case 2:
                placeOrder(1);
                break;
            case 3:
                Main.loginMenu();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Please choose from 1-4");

        }
    }

    public void placeOrder(int n){
        char choice;
        Order order = new Order();

        do {
            viewItems();

            System.out.println("Enter the ID of pizza to order: ");
            int id = scanner.nextInt();

            System.out.println("Enter the quantity: ");
            int quantity = scanner.nextInt();

            order.pizzaOrder(id, quantity, n, getName());

            System.out.println("Do you want to continue adding to your order? (Y/N)");
            choice = scanner.next().charAt(0);
            n++;

        } while (choice=='Y' || choice == 'y');

        finalizeOrder(n);
    }

    public void finalizeOrder(int n){
       System.out.println("1. Confirm Order");
       System.out.println("2. Add To Order ");
       System.out.println("3. Cancel Order ");
       int choice = scanner.nextInt();

       switch(choice){
           case 1:
               confirmOrder();
               menu();
               break;
           case 2:
               // go back to placing the order
               placeOrder(n);
               break;
           case 3:
               cancelOrder();
               menu();
               break;

           default:
               System.out.println("Error, please choose from 1-4");
       }
    }

    public void confirmOrder(){
        try {
            Order order = new Order();
            order.finalOrder();
            System.out.println("Enter Amount to Pay: ");
            double amount = scanner.nextDouble();
            order.confirmOrder(amount, getName());
        } catch (Exception e){
            System.out.println("Error. Enter valid amount");
        }
    }

    public void viewItems(){
        Pizza pizza = new Pizza();
        pizza.pizzaMenu();
    }

    public void cancelOrder(){
       Order order = new Order();
       order.cancelOrder();
    }
}
