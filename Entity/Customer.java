package Entity;

import java.time.LocalDate;
import java.lang.*;

public class Customer extends Person {
    private String customerId;
    private String totalDays;
    private double totalPrice;

    public Customer() {
    }

    public Customer(String name, String age, String contactNum,
            String customerId, String totalDays) {

        super(name, age, contactNum);
        this.customerId = customerId;
        this.totalDays = totalDays;
        this.totalPrice = calculateTotalPrice();
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(String totalDays) {
        this.totalDays = totalDays;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private double calculateTotalPrice() {
        return Double.parseDouble(totalDays) * 2500.0;
    }

    public void showInfo() {

        // System.out.println("--------Customer Info---------");
        super.showInfo();
        System.out.println("Customer ID: " + customerId);
        System.out.println("Total days stayed: " + totalDays);
        System.out.println("Per Night Cost: 5000 Taka");
        System.out.println("Total price: " + totalPrice + " taka");

    }

    public Customer parseCustomer(String data) {
        String[] tokens = data.split(",");
        String name = tokens[1];
        String age = tokens[2];
        String contactNum = tokens[3];
        String customerId = tokens[0];
        String totalDays = tokens[4];

        return new Customer(name, age, contactNum, customerId, totalDays);
    }

    @Override
    public String toString() {
        return getCustomerId() + "," + getName() + "," + getAge() + "," + getContactNum() + "," + getTotalDays() + ","
                + getTotalPrice();
    }

}
