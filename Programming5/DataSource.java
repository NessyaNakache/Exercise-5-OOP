package Programming5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DataSource {

    public static List<Customer> allCustomers;
    public static List<Order> allOrders;
    public static List<Product> allProducts;
    public static List<OrderProduct> allOrderProducts;
    // Update this path according to your data files location
    public static String basePath = "data/Ex05IBL/";
    public static String customersPath = basePath +"customers.txt";
    public static String ordersPath = basePath +"orders.txt";
    public static String productsPath = basePath +"products.txt";
    public static String orderProductPath = basePath +"orderProduct.txt";

    static
    {
        try {
            allCustomers = readCustomersfromFile();
            allOrders = readOrdersfromFile();
            allProducts = readProductsfromFile();
            allOrderProducts = readOrderProductsfromFile();
        } catch (IOException e) { e.printStackTrace(); }
    }
    public static List<Customer> readCustomersfromFile() throws IOException {
        //To Do
        return null;
    }

    public static List<Order> readOrdersfromFile() throws IOException {
        List<String> SOrders;
        try (Stream<String> lines = Files.lines(Paths.get(ordersPath))) {
            SOrders = lines.collect(Collectors.toList());

            for (int i = 0; i < SOrders.size(); i++) {
                allOrders.add(new Order(SOrders.get(i)));
            }

            allOrders.stream().forEach(lines, l -> {new Order(l);}).collect(Collectors.toList());

        }
        return allOrders;
    }

    public static List<Product> readProductsfromFile() throws IOException {
        //To Do
        return null;
    }

    public static List<OrderProduct> readOrderProductsfromFile() throws IOException {
        List<String> SOrderProducts;
        try (Stream<String> lines = Files.lines(Paths.get(orderProductPath))) {
            SOrderProducts = lines.collect(Collectors.toList());

            for (int i = 0; i < SOrderProducts.size(); i++) {
                allOrderProducts.add(new OrderProduct(SOrderProducts.get(i)));
            }

            allOrderProducts.stream().forEach(lines, l -> {new OrderProduct(l);}).collect(Collectors.toList());

        }
        return allOrderProducts;
    }
}


