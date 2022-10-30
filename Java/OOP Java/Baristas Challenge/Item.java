class Item {
    private String name;
    private double price;

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
}