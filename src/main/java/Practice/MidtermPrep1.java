package Practice;

class Item {
    private String name;
    private int price;

    public Item(String name, int price){
        this.name = name;
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    public double taxCalculator(){
        return 0.0;
    }
}

class Chocolate extends Item{
    private double cocoaPercentage;
    public Chocolate(String name, int price, double cocoaPercentage){
        super(name,price);
        this.cocoaPercentage = cocoaPercentage;
    }

    @Override
    public double taxCalculator(){
        return 0.12 * getPrice();
    }
}

class Cigarette extends Item{
    private double nicotinePercentage;
    public Cigarette(String name, int price, double nicotinePercentage){
        super(name,price);
        this.nicotinePercentage = nicotinePercentage;
    }
    @Override
    public double taxCalculator(){
        return 0.89 * getPrice();
    }
}
