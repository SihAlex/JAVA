import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    protected static List<Integer> clients = new ArrayList<>();
    protected static List<Order> orders = new ArrayList<>();
    protected static Map<Order, Integer> closedOrdersPoints = new HashMap<>();

    public static void main(String[] args) {
        Client client = new Client(1);

        Menu defaultGaspacho = new Gaspacho.Builder().build();
        Menu spicyGaspacho = new Gaspacho.Builder()
                .tabascoOrder(30)
                .build();
        Menu bigGaspacho = new Gaspacho.Builder()
                .pepperOrder(40)
                .tomatoesOrder(400)
                .build();
        client.makeOrder(defaultGaspacho, spicyGaspacho, bigGaspacho);

        showOrders();

        client.closeOrder(defaultGaspacho, 3);

        showOrders();

        showClosedOrders();
    }

    public static void showOrders() {
        System.out.println("===========Orders in progress===========");
        for (Order order : orders) {
            System.out.println("Client: " + order.getClientId());
            System.out.println("Dish: " + order.getDish().getDishName());
            System.out.println("Price: " + order.getDish().getDishPrice());

            order.getDish().showComponents();
            System.out.println("________________________________________");
            System.out.println();
        }
    }

    public static void showClosedOrders() {
        System.out.println("=============Closed orders=============");
        System.out.println(closedOrdersPoints);
        System.out.println("________________________________________");
    }
}

class Client extends Restaurant {
    private int clientId;

    public Client(int clientId) {
        if (isIdOccupied(clientId)) {
            System.out.println("ID was already taken!");
        } else {
            this.clientId = clientId;
        }
    }

    private boolean isIdOccupied(int clientId) {
        return clients.contains(clientId);
    }

    public int getClientId() {
        return this.clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void makeOrder(Menu... dishes) {
        for (Menu dish : dishes) {
            Order order = new Order(dish, clientId);
            orders.add(order);
        }
    }

    public void closeOrder(Menu dish, int points) {
        for (Order order : orders) {
            if (order.getClientId() == this.getClientId() && order.getDish() == dish.getDish())  {
                rateOrder(order, points);
            }
        }

        orders.removeIf(item -> item.getClientId() == this.getClientId() && item.getDish() == dish.getDish());
    }

    void rateOrder(Order order, int points) {
        closedOrdersPoints.put(order, points);
    }
}

class Order extends Client {
    Menu dish;

    public Order (Menu dish, int clientId) {
        super(clientId);
        this.dish = dish;
    }

    public Menu getDish() {
        return this.dish;
    }
}