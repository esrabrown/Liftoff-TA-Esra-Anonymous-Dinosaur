package com.cafemanager.cafe;

import com.stripe.Stripe;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import com.stripe.param.CustomerListParams;

public class CustomerList {
    public static void main(String[] args) {
        Stripe.apiKey = "sk_test_51Oz9N1LnssI0iBqMPWFgTeI9wYxKQmPbtFRKuTmczAHzCR6gFnwjisbXMdkNhoCNHhk6X39ufo0JTTwCuW4OCPDp00eIMwzVu2";
        System.out.println("Existing Customer IDs:");

        // Fetch a list of customers
        CustomerListParams params =
                CustomerListParams.builder()
                        .setLimit(3L)
                        .build();
        try {
            CustomerCollection customers =
                    Customer.list(params);
            for (Customer customer : customers.getData()) {
                System.out.println(customer.getId());
            }
        } catch (
                Exception e) {
            System.out.println(e);
        }
    }
}



//     Fetch a list of customers, filtered by email
//     CustomerListParams params =
//       CustomerListParams.builder()
//         .setEmail("jenny.rosen@example.com")
//         .build();
//     // /v1/customers?email=jenny.rosen@example.com
//     try {
//       CustomerCollection customers =
//         Customer.list(params);
//       for(Customer customer : customers.getData()) {
//         System.out.println(customer.getId());
//         System.out.println(customer.getEmail());
//       }
//     } catch(Exception e) {
//       System.out.println(e);
//     }
//}
