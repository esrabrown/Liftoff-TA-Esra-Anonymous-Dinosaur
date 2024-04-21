package com.cafemanager.cafe.controller;

import com.stripe.Stripe;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;

public class StripeController
{
    private static String key = "sk_test_51Oz9N1LnssI0iBqMPWFgTeI9wYxKQmPbtFRKuTmczAHzCR6gFnwjisbXMdkNhoCNHhk6X39ufo0JTTwCuW4OCPDp00eIMwzVu2";

    public static void createCustomer(String email, String name)
    {
        Stripe.apiKey = key;

        //  create a Stripe customer WITH params.
        CustomerCreateParams params =
                CustomerCreateParams.builder()
                        .setEmail("Tito.jackson@heehee.com")
                        .setName("Tito Jackson")
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
