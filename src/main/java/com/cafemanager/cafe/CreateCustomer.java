package com.cafemanager.cafe;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;



public class CreateCustomer {
    public static void main(String[] args) throws StripeException {
        Stripe.apiKey = "sk_test_51Oz9N1LnssI0iBqMPWFgTeI9wYxKQmPbtFRKuTmczAHzCR6gFnwjisbXMdkNhoCNHhk6X39ufo0JTTwCuW4OCPDp00eIMwzVu2";
        System.out.println("Customer created:");

//  ----------------------------------   create a customer WITH params.
        CustomerCreateParams params =
                CustomerCreateParams.builder()
                        .setEmail("michael.jackson@heehee.com")
                        .setName("Michael Jackson")
                        .build();
        try {
            Customer customer =
                    Customer.create(params);

            System.out.println(customer);
        } catch(Exception e) {
            System.out.println(e);
        }





    }
}