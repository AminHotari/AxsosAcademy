import java.util.ArrayList;
public class CoffeeKiosk{
    private ArrayList<Item> menu = new ArrayList<Item>();
    private ArrayList<Order> orders = new ArrayList<Order>();

    public CoffeeKiosk(){
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price){
        Item item1 = new Item(name, price);
        this.menu.add(item1);
        // item1.setIndex(menu.indexOf(item1)); // ask
        item1.setIndex(menu.size()-1);
    }

    public void displayMenu(){

        for(int i=0;i<menu.size();i++){
            System.out.println(i +" "+menu.get(i).getNameofItem()+" -- "+"$"+ menu.get(i).getPriceOfItem());
        }

        // for(Item x : this.menu){
        //     System.out.println(x.getIndex()+" "+x.getNameofItem()+" -- "+"$"+x.getPriceOfItem());
        // }
    }

        public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        // Show the user the menu, so they can choose items to add.
        
        Order newOrder = new Order(name);
        displayMenu();

    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {

            // int itemIndex = Integer.parseInt(itemNumber);
            // Item yourOrder = this.menu.get(itemIndex);
            // newOrder.addItem(yourOrder);
            // System.out.println("Please enter a menu item index or q to quit:");
            // itemNumber = System.console().readLine();


            Item item = menu.get(Integer.parseInt(itemNumber));
            newOrder.addItem(item);

            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();

            // Get the item object from the menu, and add the item to the order
            // Ask them to enter a new item index or q again, and take their input
        }

        // newOrder.display();

        newOrder.display();

        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        
    }


}