import java.util.Scanner;

public class Main {
    static UserDatabase database;

    public static void main (String[] args){

        database = new UserDatabase();
        loginMenu();

    }

    public static void loginMenu(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Welcome to the Pizzeria!");
            System.out.println("1. Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Create an Account");
            System.out.println("4. View Pizzeria Menu");
            System.out.println("5. Quit");
            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    login(scanner);
                    break;
                case 2:
                    adminLogin(scanner);
                    break;
                case 3:
                    newUser(scanner);
                    break;
                case 4:
                    viewItems();
                    break;
                case 5:
                    System.out.println("Thank you for using the system!");
                    System.exit(0);

            }


        } catch (Exception e){
            System.out.println("Please choose from 1-4");
            loginMenu();
        }


    }

    public static void login(Scanner scanner){
        try {
            System.out.println("Enter your username: ");
            String name = scanner.next();
            System.out.println("Enter your password: ");
            String password = scanner.next();

            int n = database.login(name, password);

            if (n != -1) {
                User user = database.getUser(n);
                user.menu();
            } else {
                System.out.println("Incorrect Username or Password");
                loginMenu();
            }

        } catch (Exception e){
            System.out.println("Login Error");
        }
    }

    public static void adminLogin(Scanner scanner){
        try {
            System.out.println("Enter your username: ");
            String name = scanner.next();
            System.out.println("Enter your password: ");
            String password = scanner.next();
            boolean isAdmin = database.adminLogin(name, password);
            if (isAdmin) {
                Admin admin = new Admin();
                admin.menu();
            } else {
                System.out.println("Incorrect username or password");
                loginMenu();
            }
        } catch (Exception e){
            System.out.println("Login Error");
        }
    }

    public static void newUser(Scanner scanner){
        try {
            System.out.println("Account Creation");
            System.out.println("Enter your username: ");
            String name = scanner.next();
            System.out.println("Enter your password: ");
            String password = scanner.next();
            boolean accountExists = database.accountExists(name);

            if(accountExists){
                System.out.println("User with name already exists");
                loginMenu();
            } else {
                User newUser = new User(name, password, "Customer");
                database.addUser(newUser);
                loginMenu();
            }
        } catch (Exception e){
            System.out.println("Login Error");
        }
    }

    public static void viewItems() {
        Pizza pizza = new Pizza();
        pizza.pizzaMenu();
        loginMenu();
    }
}
