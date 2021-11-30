package ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class ProductInfoClient {

    private static final Logger logger = Logger.getLogger(ProductInfoClient.class.getName());

    public static void main(String[] args) throws InterruptedException {
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("openshift-git", 50055)
//                .usePlaintext()
//                .build();
//
//        ProductInfoGrpc.ProductInfoBlockingStub stub =
//                ProductInfoGrpc.newBlockingStub(channel);
//
//        ProductInfoOuterClass.ProductID productID = stub.addProduct(
//                ProductInfoOuterClass.Product.newBuilder()
//                        .setName("Samsung S10")
//                        .setDescription("Samsung Galaxy S10 is the latest smart phone, " +
//                                "launched in February 2019")
//                        .setPrice(700.0f)
//                        .build());
//        logger.info("Product ID: " + productID.getValue() + " added successfully.");
//
//        ProductInfoOuterClass.Product product = stub.getProduct(productID);
//        logger.info("Product: " + product.toString());
//        channel.shutdown();
        SpringApplication.run(ProductInfoClient.class, args);
        System.out.println("Client Started Ya Hu....");
    }
}
