package Programming5;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static Programming5.DataSource.*;
import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.*;

public class BL implements IBL {
    @Override
    public Product getProductById(long productId) {
        //To do
        return null;
    }

    @Override
    public Order getOrderById(long orderId) {
        return allOrders.stream()
                .filter(o -> o.getOrderId() == orderId)
                .findAny()
                .orElse(null);
    }

    @Override
    public Customer getCustomerById(long customerId) {
        //To do
        return null;
    }


    @Override
    public List<Product> getProducts(ProductCategory cat, double price) {
        //To do
        return null;
    }

    @Override
    public List<Customer> popularCustomers() {
        //To do
        return null;
    }

    @Override
    public List<Order> getCustomerOrders(long customerId) {
        return allOrders.stream()
                .filter(co -> co.getCustomrId() == customerId)
                .collect(Collectors.toList());
    }

    @Override
    public long numberOfProductInOrder(long orderId) {
        //To do
        return 0;
    }

    @Override
    public List<Product> getPopularOrderedProduct(int orderedtimes) {
        //To do
        return null;
    }

    @Override
    public List<Product> getOrderProducts(long orderId)
    {
        return allOrderProducts.stream()
                .filter(op -> op.getOrderId() == orderId)
                .sorted(Comparator.comparing(OrderProduct::getProductId))
                .map(op -> getProductById(op.getProductId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> getCustomersWhoOrderedProduct(long productId) {
        //To do
        return null;
    }

    //work on that
    @Override
    public Product getMaxOrderedProduct() {
        //To do
        return null;

    }

    //rework
    @Override
    public double sumOfOrder(long orderID) {
        return allOrders.stream()
                .filter(op -> op.getOrderId() == orderID)
                .count();
    }

    //rework
    @Override
    public List<Order> getExpensiveOrders(double price) {
        return allOrders.stream()
                .filter(o -> o.getOrderId() >= price)
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> ThreeTierCustomerWithMaxOrders() {
        //To do
        return null;

    }

}
