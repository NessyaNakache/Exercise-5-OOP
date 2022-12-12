package Programming5;

import java.util.*;
import java.util.stream.Collectors;

import static Programming5.DataSource.*;
//import static java.util.Collections.reverseOrder;
//import static java.util.Map.Entry.comparingByValue;
//import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.*;

public class BL implements IBL {
    @Override
    public Product getProductById(long productId) {
        return allProducts.stream()
                .filter(prod->prod.getProductId()==productId)
                .findAny()
                .orElse(null);
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
    public double sumOfOrderedQuantities(long orderID) {
        List<OrderProduct> orderProducts = allOrderProducts.stream()
                .filter(op -> op.getOrderId() == orderID)
                .toList();

        return orderProducts.stream()
                .map(op -> op.getQuantity())
                .reduce(0,Integer::sum);
    }

    @Override
    public List<Product> getPopularOrderedProduct(int orderedQuantity) {
        return allProducts.stream()
                .distinct()
                .filter(op -> sumOfOrderedQuantities(op.getProductId()) > orderedQuantity)
                .collect(Collectors.toList());
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

    @Override
    public Product getMaxOrderedProduct() {
        Map<OrderProduct, Long> list = new HashMap<>();
        list = allOrderProducts.stream()
                .collect(Collectors.groupingBy(op -> op, Collectors.counting()));

        Map<OrderProduct, Long> sorted = list .entrySet() .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect( toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2)
                        -> e2, LinkedHashMap::new));

        Map.Entry<OrderProduct,Long> entry = sorted.entrySet().iterator().next();
        OrderProduct key= entry.getKey();

        return getProductById(key.getProductId());
    }

    @Override
    public double sumOfOrder(long orderID) {
        List<OrderProduct> orderProducts = allOrderProducts.stream()
                .filter(op -> op.getOrderId() == orderID)
                .toList();

        return orderProducts.stream()
                .map(op -> op.getQuantity()
                        * getProductById(op.getProductId()).getPrice())
                .reduce(0.00,Double::sum);
    }

    @Override
    public List<Order> getExpensiveOrders(double price) {
        return allOrders.stream()
                .filter(o -> sumOfOrder(o.getOrderId()) > price)
                .sorted(Comparator.comparing(Order::getOrderId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> ThreeTierCustomerWithMaxOrders() {
        //To do
        return null;

    }

}
