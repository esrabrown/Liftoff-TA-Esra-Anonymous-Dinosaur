package com.cafemanager.cafe;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.CustomerUpdateParams;


public class CreateCustomer {
    public static void main(String[] args) throws StripeException {
        Stripe.apiKey = "sk_test_51Oz9N1LnssI0iBqMPWFgTeI9wYxKQmPbtFRKuTmczAHzCR6gFnwjisbXMdkNhoCNHhk6X39ufo0JTTwCuW4OCPDp00eIMwzVu2";
        System.out.println("Make requests!");

// ---------------------------------- create a customer with no params.
//        CustomerCreateParams params =
//                CustomerCreateParams.builder()
//                        .build();
//        try {
//            Customer customer =
//                    Customer.create(params);
//
//            System.out.println(customer);
//        } catch(Exception e) {
//            System.out.println(e);
//        }

//  ----------------------------------   create a customer WITH params.
//        CustomerCreateParams params =
//                CustomerCreateParams.builder()
//                        .setEmail("michael.jackson@heehee.com")
//                        .setName("Michael Jackson")
//                        .build();
//        try {
//            Customer customer =
//                    Customer.create(params);
//
//            System.out.println(customer);
//        } catch(Exception e) {
//            System.out.println(e);
//        }


//  ----------------------------------   create a customer with nested object
//        CustomerCreateParams params =
//                CustomerCreateParams.builder()
//                        .setPaymentMethod("pm_card_visa")
//                        .setInvoiceSettings(
//                                CustomerCreateParams.InvoiceSettings.builder()
//                                        .setDefaultPaymentMethod("pm_card_visa")
//                                        .build()
//
//                        )
//                        .build();
//        try {
//            Customer customer =
//                    Customer.create(params);
//
//            System.out.println(customer);
//        } catch(Exception e) {
//            System.out.println(e);
//        }

// ---------------------------------- create a customer with a list of strings.
//        CustomerCreateParams params =
//                CustomerCreateParams.builder()
//                        .addPreferredLocale("en")
//                        .addPreferredLocale("es")
//                        .build();
//        try {
//            Customer customer =
//                Customer.create(params);
//                System.out.println(customer);
//            } catch(Exception e) {
//                System.out.println(e);
//        }


//  ---------------------------------- retrieve a customer
//        try {
//            Customer customer =
//                    Customer.retrieve("cus_PwUVsa3opPI90M");
//
//            System.out.println(customer);
//        } catch(Exception e) {
//            System.out.println(e);
//        }



    }
}