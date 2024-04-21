package com.cafemanager.cafe;

import com.stripe.Stripe;
import com.stripe.StripeClient;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

public class CreatePayment {

    public static void main(String[] args) throws StripeException {
        Stripe.apiKey = "sk_test_51Oz9N1LnssI0iBqMPWFgTeI9wYxKQmPbtFRKuTmczAHzCR6gFnwjisbXMdkNhoCNHhk6X39ufo0JTTwCuW4OCPDp00eIMwzVu2";

        // Set your secret key. Remember to switch to your live secret key in production.
// See your keys here: https://dashboard.stripe.com/apikeys
        StripeClient client = new StripeClient("sk_test_4eC39HqLyjWDarjtT1zdp7dc");

        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(66666L)
                        .setCurrency("usd")
                        .setAutomaticPaymentMethods(
                                PaymentIntentCreateParams.AutomaticPaymentMethods.builder().setEnabled(true).build()
                        )
                        .build();
        try {
            PaymentIntent paymentIntent =
                    PaymentIntent.create(params);

            System.out.println(paymentIntent);
        } catch(Exception e) {
            System.out.println(e);
        }


        PaymentIntent paymentIntent = client.paymentIntents().create(params);
    }
}