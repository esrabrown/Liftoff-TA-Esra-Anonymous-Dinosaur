package com.cafemanager.cafe;

import com.stripe.Stripe;
import com.stripe.model.*;
import com.stripe.param.*;

public class EditCustomer {
    public static void main(String[] args) {
        Stripe.apiKey = "sk_test_51Oz9N1LnssI0iBqMPWFgTeI9wYxKQmPbtFRKuTmczAHzCR6gFnwjisbXMdkNhoCNHhk6X39ufo0JTTwCuW4OCPDp00eIMwzVu2";
        System.out.println("Make requests!");

        // // Update the email address for a customer
        // CustomerUpdateParams params =
        //   CustomerUpdateParams.builder()
        //     .setEmail("jr-2@example.com")
        //     .build();
        //
        // try {
        //   Customer customer = Customer.retrieve(
        //     "cus_IVV7iFxlhmoFdX"
        //   );
        //   Customer updatedCustomer = customer.update(
        //       params
        //   );
        //   System.out.println(customer.getEmail());
        //   System.out.println(updatedCustomer.getEmail());
        // } catch(Exception e) {
        //   System.out.println(e);
        // }


        // Update a customer with nested params
         CustomerUpdateParams params =
           CustomerUpdateParams.builder()
             .setInvoiceSettings(
               CustomerUpdateParams
                 .InvoiceSettings
                 .builder()
                 .addCustomField(
                   CustomerUpdateParams
                     .InvoiceSettings
                     .CustomField
                     .builder()
                     .setName("Rick James")
                     .setValue("Cocaine is Expensive")
                     .build()
                 )
                 .addCustomField(
                   CustomerUpdateParams
                     .InvoiceSettings
                     .CustomField
                     .builder()
                     .setName("Eddie Murphy")
                     .setValue("I'm rich!")
                     .build()
                 )
                 .build()
             )
             .build();

         try {
           Customer customer = Customer.retrieve(
             "cus_PwUmZ6FNAtRHv7"
           );
           Customer updatedCustomer = customer.update(
               params
           );
           System.out.println(updatedCustomer.getInvoiceSettings());
         } catch(Exception e) {
           System.out.println(e);
         }


        // Delete a customer
        // try {
        //   // Fetch API call
        //   Customer customer = Customer.retrieve(
        //       "cus_IVV7iFxlhmoFdX"
        //   );
        //   // Delete API call.
        //   Customer deletedCustomer = customer.delete();
        //   System.out.println(deletedCustomer);
        // } catch(Exception e) {
        //   System.out.println(e);
        // }

    }
}