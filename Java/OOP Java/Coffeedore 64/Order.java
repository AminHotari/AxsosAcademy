import java.util.ArrayList;
class Order {
    private String name;
    private boolean ready;
    private double total;
    private ArrayList<Item> items = new ArrayList<Item>();

    public Order() {
        this.name = "Guest";
        this.items = new ArrayList<Item>();       
    }

    public Order(String name) {
        this.name = name;
        // this.items = new ArrayList<Item>();
    }

    public String getNameOfOrder(){
        return name;
    }

    public void setNameOfOrder(String name){
        this.name = name;
    }

    public boolean getIsOrderReady(){
        return ready;
    }

    public void setIsOrderReady(boolean ready){
        this.ready = ready;
    }

    public ArrayList<Item> getArrayList(){
        return items;
    }

    public void setArrayList(ArrayList<Item> items){
        this.items = items;
    }

    public void addItem(Item item){
        this.items.add(item);
        // this.items.getPriceOfItem();
    }

    public String getStatusMessage(){
        if(this.ready){
            return "Your order is ready.";
        }
        else{
            return "Thank you for watiing. Your order will be ready soon.";
        }
    }


    public void display(){
        System.out.println("Customer Name: " + this.name);        
        for(int i=0; i<items.size(); i++){
            System.out.println(items.get(i).getNameofItem()+ " - "+ items.get(i).getPriceOfItem());
        }
        System.out.println("Total: $" + getOrderTotal());
    }

    public double getOrderTotal(){
        for(int i=0; i<items.size(); i++){
            this.total += items.get(i).getPriceOfItem();
        }
        return this.total;

    }


}