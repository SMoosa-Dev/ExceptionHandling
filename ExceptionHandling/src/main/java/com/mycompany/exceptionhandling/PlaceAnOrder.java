package com.mycompany.exceptionhandling;

import java.util.Scanner;

public class PlaceAnOrder {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int itemNumber;
        int quantity;
        double price = 0;
        double total;

        try {

            System.out.print("Enter item number: ");
            String itemInput = input.nextLine();

            try {
                itemNumber = Integer.parseInt(itemInput);
            } catch (NumberFormatException e) {
                throw new OrderException(OrderMessages.messages[0]);
            }

            if (itemNumber < 0 || itemNumber > 9999) {
                throw new OrderException(OrderMessages.messages[1]);
            }

            if (itemNumber == 111) {
                price = 0.89;
            } else if (itemNumber == 222) {
                price = 1.47;
            } else if (itemNumber == 333) {
                price = 2.43;
            } else if (itemNumber == 444) {
                price = 5.99;
            } else {
                throw new OrderException(OrderMessages.messages[4]);
            }

            System.out.print("Enter quantity: ");
            String quantityInput = input.nextLine();

            try {
                quantity = Integer.parseInt(quantityInput);
            } catch (NumberFormatException e) {
                throw new OrderException(OrderMessages.messages[2]);
            }

            if (quantity < 1 || quantity > 12) {
                throw new OrderException(OrderMessages.messages[3]);
            }

            total = quantity * price;

            System.out.println();
            System.out.println("ORDER DETAILS");
            System.out.println("---------------------");
            System.out.println("Item Number: " + itemNumber);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Amount Due: $" + total);

        } catch (OrderException e) {

            System.out.println("ERROR: " + e.getMessage());

        }

        input.close();
    }
}
