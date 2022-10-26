import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
        Item item1 = new Item();
        item1.name = "mocha";
        item1.price = 2.5;

        Item item2 = new Item();
        item2.name = "latte";
        item2.price = 3;

        Item item3 = new Item();
        item3.name = "drip coffee";
        item3.price = 3.5;

        Item item4 = new Item();
        item4.name = "capuccino";
        item4.price = 2;

        Order order1 = new Order();
        order1.name = "Cindhuri";
        System.out.println(order1.total);

        //Cindhuri’s order is now ready. Update her status.
        order1.ready = true;
        
        Order order2 = new Order();
        order2.name = "Jimmy";

        //Add item1 to order2's item list and increment the order's total
        order2.items.add(item1);
        order2.total += item1.price;

        //Jimmy’s order is now ready. Update his status.
        order2.ready = true;
        

        Order order3 = new Order();
        order3.name = "Noah";

        //order3 ordered a cappucino. Add the cappuccino to their order list and to their tab.
        order3.items.add(item4);
        order3.total += item4.price;


        Order order4 = new Order();
        order4.name = "Sam";

        //order4 added a latte. Update accordingly.
        order4.items.add(item2);
        order4.total = item2.price;

        //Sam ordered more drinks - 2 lattes. Update their order as well.
        order4.items.add(item2);
        order4.items.add(item2);
        order4.total = item2.price * 2;


        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);

        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);

        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);

    }
}