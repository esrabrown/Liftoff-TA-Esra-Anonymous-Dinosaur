package com.cafemanager.cafe;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Balance;

public class CheckBalance {
    public static void main(String[] args) throws StripeException {
        Stripe.apiKey = "sk_test_51Oz9N1LnssI0iBqMPWFgTeI9wYxKQmPbtFRKuTmczAHzCR6gFnwjisbXMdkNhoCNHhk6X39ufo0JTTwCuW4OCPDp00eIMwzVu2";

        Balance balance = Balance.retrieve();

        // Convert the Balance object to JSON using Gson
        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(balance);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        // Dynamically access the 'amount' value based on the JSON structure
        JsonElement availableElement = jsonObject.get("available");
        int amountValue = 0; // Default value in case 'amount' is not found
        if (availableElement.isJsonArray() && availableElement.getAsJsonArray().size() > 0) {
            JsonElement amountElement = availableElement.getAsJsonArray().get(0).getAsJsonObject().get("amount");
            if (amountElement != null && !amountElement.isJsonNull()) {
                amountValue = amountElement.getAsInt();
            }
        }

        System.out.println("The available amount is: " + amountValue);
    }
}