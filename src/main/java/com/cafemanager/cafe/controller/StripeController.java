package com.cafemanager.cafe.controller;

import com.stripe.Stripe;
import org.springframework.web.bind.annotation.*;


@RestController
public class StripeController {
    private static String key = "sk_test_51Oz9N1LnssI0iBqMPWFgTeI9wYxKQmPbtFRKuTmczAHzCR6gFnwjisbXMdkNhoCNHhk6X39ufo0JTTwCuW4OCPDp00eIMwzVu2";
    private final StripeService stripeService;

    public StripeController(StripeService stripeService) {
        this.stripeService = stripeService;
        Stripe.apiKey = key;
    }

    @PostMapping("/charge")
    public Charge charge(@RequestBody ChargeRequest chargeRequest) throws StripeException {
        return stripeService.charge(chargeRequest);
    }

    @PostMapping("/refund")
    public Refund refund(@RequestBody RefundRequest refundRequest) throws StripeException {
        return stripeService.refund(refundRequest);
    }

    @GetMapping("/customer")
    public Customer getCustomer(@RequestParam String customerId) throws StripeException {
        return stripeService.getCustomer(customerId);
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody CustomerRequest customerRequest) throws StripeException {
        return stripeService.createCustomer(customerRequest);
    }

}