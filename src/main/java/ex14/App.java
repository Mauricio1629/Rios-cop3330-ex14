/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Mauricio Rios
 */
package ex14;

import java.util.Scanner;

public class App {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        double order = myApp.getOrderAmount();
        String state = myApp.getState();
        double subtotal = myApp.getSubtotal(order);
        double tax = myApp.getTax(state, subtotal);
        double total = myApp.getTotal(subtotal, tax);
        String outputString = myApp.generateOutputString(subtotal, tax, total);
        myApp.printOutput(outputString);
    }

    public double getOrderAmount() {
        System.out.print("Enter is the order amount? ");
        return in.nextDouble();
    }

    public String getState() {
        System.out.print("What is the state? ");
        return in.next();
    }

    public double getSubtotal(double order) {
        return Math.round(order*100d)/100d;
    }

    public double getTax(String state, double subtotal){
        if(!state.equals("WI")) {
            System.out.print("The total is $" + subtotal);
            System.exit(0);
        }
            double tax = subtotal * 0.055;
            return Math.round(tax*100d)/100.0d;
    }

    public double getTotal(double subtotal, double tax){
        return subtotal+tax;
    }
    
    public String generateOutputString(double subtotal, double tax, double total) {
        return "The subtotal is $"+subtotal+".\nThe tax is $"+tax+".\nThe total is $"+total+".";
    }

    public void printOutput(String outputString) {
        System.out.print(outputString);
    }
}