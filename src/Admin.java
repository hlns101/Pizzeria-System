import java.util.Scanner;

public class Admin extends User {

    Pizza pizza = new Pizza();

    Scanner scanner = new Scanner(System.in).useDelimiter("\n"); // For input to take spaces . Credit to https://stackoverflow.com/a/52621489

    Admin(){

    }
    Admin(String name, String password, String role){
        super(name,password,role);
    }

    public void menu(){
        System.out.println("Welcome Admin");
        System.out.println("1.  View Pizzas");
        System.out.println("2.  Add Pizza");
        System.out.println("3.  Update Pizza");
        System.out.println("4.  Delete Pizza");
        System.out.println("5.  Log Out");
        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                viewItems();
                menu();
                break;
            case 2:
                addPizza();
                break;
            case 3:
                update();
                break;
            case 4:
                deletePizza();
                menu();
                break;
            case 5:
                logout();
            default:
                System.out.println("Please choose from 1-6");
        }

    }

    public void addPizza () {
        try {
            System.out.println(" Adding Pizza ");
            System.out.println("Enter Pizza ID: ");
            int id = scanner.nextInt();
            boolean unique = pizza.uniquePizzaID(id);

            if (!unique) {
                System.out.println("Error: Pizza with ID already exists");
                menu();
            }

            System.out.println("Enter Pizza Name: ");
            String name = scanner.next();
            System.out.println("Enter Pizza Size: ");
            String size = scanner.next();
            System.out.println("Enter Pizza Price: ");
            double price = scanner.nextDouble();

            Pizza newPizza = new Pizza(id, name, size, price);
            pizza.addPizza(newPizza);
            System.out.println("Pizza successfully added!");
            menu();
        } catch (Exception e){
            System.out.println("Error adding pizza. Try again");
        }
    }

    public void update() {
        System.out.println("     Update Pizza   ");
        System.out.println("1.  Update Pizza ID  ");
        System.out.println("2.  Update Pizza Name  ");
        System.out.println("3.  Update Pizza Size   ");
        System.out.println("4.  Update Pizza Price  ");
        System.out.println("5.  Back ");

        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                updatePizzaID();
                menu();
                break;

            case 2:
                updatePizzaName();
                menu();
                break;

            case 3:
                updatePizzaSize();
                menu();
                break;
            case 4:
                updatePizzaPrice();
                menu();
                break;
            case 5:
                menu();
                break;
            default:
                System.out.println("Error");

        }
    }

    public void updatePizzaID() {
        viewItems();
        System.out.println("Enter ID of the pizza to be updated: ");
        int id = scanner.nextInt();
        pizza.updatePizzaID(id);
    }

    public void updatePizzaName() {
        viewItems();
        System.out.println("Enter ID of pizza to update Name of: ");
        int id = scanner.nextInt();
        pizza.updatePizzaName(id);
    }

    public void updatePizzaSize(){
        viewItems();
        System.out.println("Enter ID of pizza to update Size of: ");
        int id = scanner.nextInt();
        pizza.updatePizzaSize(id);
    }

    public void updatePizzaPrice(){
        viewItems();
        System.out.println("Enter ID of pizza to update Size of: ");
        int id = scanner.nextInt();
        pizza.updatePizzaPrice(id);
    }

    public void deletePizza(){
        viewItems();
        System.out.println("Enter ID of the pizza to be deleted: ");
        int id = scanner.nextInt();
        pizza.deletePizza(id);
    }

    public void viewItems(){
        Pizza pizza = new Pizza();
        pizza.pizzaMenu();
    }
}
