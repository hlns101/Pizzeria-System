import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Pizza {
    int pizzaID;
    String name, size;
    double price;

    static Pizza pizza1 = new Pizza(1, "Cheese", "Solo", 7);
    static Pizza pizza2 = new Pizza(2, "Pepperoni", "Medium", 15);

    static ArrayList<Pizza> pizzas = new ArrayList<>(Arrays.asList(pizza1, pizza2));

    ArrayList<String> pizzaNames = new ArrayList<>();
    ArrayList<String> sizes = new ArrayList<>();
    ArrayList<Double> prices = new ArrayList<>();

    ArrayList<Integer> pizzaIDs = new ArrayList<>();

    Pizza(){

    }

    Pizza (int pizzaID, String name, String size, double price) {
        this.pizzaID = pizzaID;
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSize(String size){
        this.size = size;
    }

    public String getSize(){
        return size;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public void setID(int pizzaID){
        this.pizzaID = pizzaID;
    }

    public int getPizzaID(){
        return pizzaID;
    }


    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
        pizzaIDs.add(pizza.getPizzaID());
        pizzaNames.add(pizza.getName());
        prices.add(pizza.getPrice());
        sizes.add(pizza.getSize());
    }

    public void deletePizza(int pizzaID){
        pizzas.removeIf(i -> i.getPizzaID() == pizzaID);
        pizzaMenu();
    }

    public void updatePizzaID (int pizzaID) {
        Scanner scanner = new Scanner(System.in);

        for(Pizza i: pizzas){
            if(i.getPizzaID() == pizzaID){
                System.out.println(pizzaDesc(pizzaID));
                System.out.println("Enter the New ID: ");
                int id = scanner.nextInt();
                boolean unique = uniquePizzaID(id);

                if (!unique) {
                    System.out.println("Error: Pizza with ID already exists");
                    break;
                }

                i.setID(id);
                System.out.println(pizzaDesc(id));
            }
        }
    }


    public void updatePizzaName(int pizzaID){
        Scanner scanner = new Scanner(System.in);
        for(Pizza i: pizzas){
            if(i.getPizzaID() == pizzaID){
                System.out.println(pizzaDesc(pizzaID));
                System.out.println("Enter the New Name: ");
                String name = scanner.next();
                i.setName(name);
                System.out.println(pizzaDesc(pizzaID));
            }
        }
    }

    public void updatePizzaSize (int pizzaID){
        Scanner scanner = new Scanner(System.in);
        for(Pizza i: pizzas){
            if(i.getPizzaID() == pizzaID){
                System.out.println(pizzaDesc(pizzaID));
                System.out.println("Enter the New Size: ");
                String size = scanner.next();
                i.setSize(size);
                System.out.println(pizzaDesc(pizzaID));
            }
        }
    }

    public void updatePizzaPrice (int pizzaID){
        Scanner scanner = new Scanner(System.in);
        for(Pizza i: pizzas){
            if(i.getPizzaID() == pizzaID){
                System.out.println(pizzaDesc(pizzaID));
                System.out.println("Enter the New Price: ");
                double size = scanner.nextDouble();
                i.setPrice(size);
                System.out.println(pizzaDesc(pizzaID));
            }
        }
    }

    public String pizzaDesc(int pizzaID){
        for(Pizza p: pizzas){
            if(p.getPizzaID() == pizzaID){
                return p.getPizzaID() + " . " + p.getName() + " Size: " + p.getSize() + " Price: " + p.getPrice();
            }
        }
        return null;
    }

    public void pizzaMenu(){
        System.out.println("-----Pizzas-----");
        for(Pizza pizzaNum: pizzas){
            System.out.println(pizzaNum.getPizzaID() + ". " + pizzaNum.getName() +  " || Size: " + pizzaNum.getSize() + " || Price: " + pizzaNum.getPrice());
        }
        System.out.println("---------------");
    }

    public boolean uniquePizzaID(int pizzaID){
        for(Pizza pizzaNum: pizzas){
            if (pizzaNum.getPizzaID() == pizzaID){
                return false;
            }
        }
        return true;
    }

}
