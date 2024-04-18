package com.cafemanager.cafe;

import com.stripe.Stripe;
import com.stripe.model.Customer;

public class FetchCustomer {
    public static void main(String[] args) {
        Stripe.apiKey = "sk_test_51Oz9N1LnssI0iBqMPWFgTeI9wYxKQmPbtFRKuTmczAHzCR6gFnwjisbXMdkNhoCNHhk6X39ufo0JTTwCuW4OCPDp00eIMwzVu2";
        System.out.println("Customer Info:");

        // Fetch a customer
         try {
           Customer customer = Customer.retrieve(
               "cus_PwUmZ6FNAtRHv7"
           );
           System.out.println(customer);
         } catch(Exception e) {
           System.out.println(e);
         }

    }
}