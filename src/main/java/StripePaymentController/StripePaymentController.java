package StripePaymentController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StripePaymentController {

    @Value("${stripe.apikey}")

    @RequestMapping("/")
    public String index() {
        return "[Replace this text with something useful.]";
    }

}
