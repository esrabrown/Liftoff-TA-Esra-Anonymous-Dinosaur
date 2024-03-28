package StripePaymentController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
// @RestController was suggested on stripe API page
public class StripePaymentController {

    @Value("${stripe.apikey}")

    @RequestMapping("/")
    public String index() {
        return "[Hello, World!]";
    }

}
