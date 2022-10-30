import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("Amin");
        Order order4 = new Order("Hotari");
        Order order5 = new Order("Hussin");

        Item item1 = new Item("Coffee", 2.5);
        Item item2 = new Item("Tea", 2);

        order3.addItem(item1);
        order4.addItem(item2);
        order2.addItem(item2);

        order3.display();
        System.out.println(order1.getNameOfOrder());

        order2.setIsOrderReady(true);
        System.out.println(order2.getStatusMessage());

        
        System.out.println(order2.getOrderTotal());



    }
}