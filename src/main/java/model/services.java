package model;
public class services {
    private String nameService;
    private double price;

    public services(String nameService, double price) {
        this.nameService = nameService;
        this.price = price;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
