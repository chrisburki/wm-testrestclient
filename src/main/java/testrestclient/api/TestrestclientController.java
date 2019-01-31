package testrestclient.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import testrestclient.model.Address;
import testrestclient.model.Customer;

import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class TestrestclientController {
    private final AtomicLong counter = new AtomicLong();

    @Value("${WM_ADDRESS_SERVICE_HOST}")
    private String wmAddressHost;

    @Value("${WM_ADDRESS_SERVICE_PORT}")
    private String wmAddressPort;

//    private final String testUrl = "http://localhost:8091/addresses?key=aa";

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="", method = RequestMethod.GET)
    public Customer findCustomer(@RequestParam("key") String key) {

        final String name = "Nia Burki";
        String addressUrl = "http://" + wmAddressHost + wmAddressPort;

        Address address = restTemplate.getForObject(
                addressUrl, Address.class);

        return new Customer(counter.incrementAndGet(), key, name + ": " + address.getPlace());
    }

}
