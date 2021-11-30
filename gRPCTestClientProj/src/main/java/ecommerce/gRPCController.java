package ecommerce;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
public class gRPCController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final Logger logger = Logger.getLogger(gRPCController.class.getName());

//    @GetMapping("/greeting")
//    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }


    @RequestMapping(value="/rest/hello", method = RequestMethod.GET, headers="Accept=application/json")
    public String hello() {


        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50055)
                .usePlaintext()
                .build();

        ProductInfoGrpc.ProductInfoBlockingStub stub =
                ProductInfoGrpc.newBlockingStub(channel);

        ProductInfoOuterClass.ProductID productID = stub.addProduct(
                ProductInfoOuterClass.Product.newBuilder()
                        .setName("Samsung S10")
                        .setDescription("Samsung Galaxy S10 is the latest smart phone, " +
                                "launched in February 2019")
                        .setPrice(700.0f)
                        .build());
        logger.info("Product ID: " + productID.getValue() + " added successfully.");

        ProductInfoOuterClass.Product product = stub.getProduct(productID);
        logger.info("Product: " + product.toString());
        channel.shutdown();

        return "Product ID: " + productID.getValue() + " added successfully. Product: " + product.toString();
    }
}