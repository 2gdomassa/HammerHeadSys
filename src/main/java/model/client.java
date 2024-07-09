
package model;

public class client {
    private int id;
    private String name, number,adress,numberServices,activeServices;
 
    public client() {
    }
 
    public client(String name, String number, String adress, String numberServices, String activeServices) {
        
        this.name = name;
        this.number = number;
        this.adress = adress;
        this.numberServices = numberServices;
        this.activeServices = activeServices;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNumberServices() {
        return numberServices;
    }

    public void setNumberServices(String numberServices) {
        this.numberServices = numberServices;
    }

    public String getActiveServices() {
        return activeServices;
    }

    public void setActiveServices(String activeServices) {
        this.activeServices = activeServices;
    }
    
    
}
