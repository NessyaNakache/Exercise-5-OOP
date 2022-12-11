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
        try {
            allOrders = Files.lines(Paths.get(ordersPath)).map(l -> new Order(l)).collect(Collectors.toList());
        }
        catch(Throwable exception){}

        return allOrders;

    }

    public static List<Product> readProductsfromFile() throws IOException {
        //To Do
        return null;
    }

    public static List<OrderProduct> readOrderProductsfromFile() throws IOException {
        try {
            allOrderProducts = Files.lines(Paths.get(orderProductPath)).map(l -> new OrderProduct(l)).collect(Collectors.toList());
        }
        catch(Throwable exception){}

        return allOrderProducts;
    }
}


