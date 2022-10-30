class Item {
    private String name;
    private double price;
    private int index;

    public String getNameofItem() {
        return name;
    }

    public void setNameOfItem(String name) {
        this.name = name;
    }

    public double getPriceOfItem() {
        return price;
    }

    public void setPriceOfItem(double price) {
        this.price = price;
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int getIndex(){
        return index;
    }

    public void setIndex(int index){
        this.index = index;
    }
}