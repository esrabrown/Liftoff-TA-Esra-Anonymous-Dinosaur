package com.cafemanager.cafe;

import com.stripe.Stripe;
import com.stripe.model.Customer;

public class DeleteCustomer {
    public static void main(String[] args) {
        Stripe.apiKey = "sk_test_51Oz9N1LnssI0iBqMPWFgTeI9wYxKQmPbtFRKuTmczAHzCR6gFnwjisbXMdkNhoCNHhk6X39ufo0JTTwCuW4OCPDp00eIMwzVu2";
        System.out.println("Deleted Customer:");

        // Delete a customer
         try {
           // Fetch API call
           Customer customer = Customer.retrieve(
               "cus_PwUVsa3opPI90M"
           );
           // Delete API call.
           Customer deletedCustomer = customer.delete();
           System.out.println(deletedCustomer);
         } catch(Exception e) {
           System.out.println(e);
         }
    }
}