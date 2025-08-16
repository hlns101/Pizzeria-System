import java.util.ArrayList;

public class Order {

    Customer customer = new Customer();

    private int orderID;

    double orderAmount;
    String pizzaOrdered;
    int pizzaQuantity;
    private double finalOrderAmount;

    static ArrayList<Order> orders = new ArrayList<>();
    static ArrayList<Order> finalOrders = new ArrayList<>();

    ArrayList<Integer> orderIDs = new ArrayList<>();

    ArrayList<Double> orderTotal = new ArrayList<>();


    Order() {

    }

    Order(int orderID, double orderAmount, String customerName) {
        this.orderID = orderID;
        this.orderAmount = orderAmount;
    }

    Order(double finalOrderAmount) {
        this.finalOrderAmount = finalOrderAmount;
    }

    public void addOrder(Order order) {
        Pizza pizza = new Pizza();
        orders.add(order);
        orderIDs.add(getOrderID());
        orderTotal.add(getOrderAmount());
    }

    public void addFinalOrder(Order order) {
        finalOrders.add(order);
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setPizzaOrdered(String pizzaOrdered){
        this.pizzaOrdered = pizzaOrdered;
    }

    public String getPizzaOrdered(){
        return pizzaOrdered;
    }

    public void setPizzaQuantity(int pizzaQuantity){
        this.pizzaQuantity = pizzaQuantity;
    }

    public int getPizzaQuantity(){
        return pizzaQuantity;
    }

    public void setFinalOrderAmount(double finalOrderAmount) {
        this.finalOrderAmount = finalOrderAmount;
    }

    public double getFinalOrderAmount() {
        return finalOrderAmount;
    }

    public void pizzaOrder(int id, int quantity, int n, String name) {
        for (Pizza i : Pizza.pizzas) {
            if (i.getPizzaID() == id) {
                double orderAmount = i.getPrice() * quantity;

                System.out.println(i.getName() + " Quantity: " + quantity);
                System.out.println("Total: " + orderAmount);

                Order newOrder = new Order(n, orderAmount, name);
                newOrder.setOrderAmount(orderAmount);
                newOrder.setOrderID(n);
                newOrder.setPizzaOrdered(i.getName());
                newOrder.setPizzaQuantity(quantity);
                addOrder(newOrder);
            }
        }
    }

    public void finalOrder() {
        double finalAmount = 0;
        System.out.println("Items in Order: ");

        for (Order i : orders) {
                System.out.println(i.getOrderID() + ".) " + i.getPizzaOrdered()  + " || Quantity:" + i.getPizzaQuantity() + " || Amount: " + i.getOrderAmount());
                finalAmount += i.getOrderAmount();
        }
        System.out.println("Final Total: " + finalAmount);

        Order finalOrder = new Order(finalAmount);
        addFinalOrder(finalOrder);
        finalOrder.setFinalOrderAmount(finalAmount);

    }

    public void confirmOrder(double amount, String name) {
        Order order = finalOrders.getFirst();
        double total = order.getFinalOrderAmount();

        if (amount >= total) {
            System.out.println("Total:  " + total + ".");
            System.out.println("Received:  " + amount + ".");
            double change = amount - total;
            System.out.println("Change:    " + change);
            System.out.println("Thank you for ordering " + name + "!");

            orders.clear();
            finalOrders.clear();

        } else {
            System.out.println("Payment Error: Amount is smaller than the total");
            cancelOrder();
        }
    }

    public void cancelOrder() {
        System.out.println("Cancelled order ");
        orders.clear();
        finalOrders.clear();
    }

}

