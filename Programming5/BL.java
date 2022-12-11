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
                .filter(op -> op.getOrderId() == orderId)
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
                .filter(op -> op.getCustomrId() == customerId)
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

    //gotta connect order product to product thru ids but dont know how to
    @Override
    public List<Product> getOrderProducts(long orderId)
    {
//        List<OrderProduct> orderProducts = allOrderProducts.stream()
//                .filter(op -> op.getOrderId() == orderId)
//                .collect(Collectors.toList());
//
//        List<Product> result;
//        long OId;
//
//        for (int i = 0; i < orderProducts.size(); i++) {
//            OId = orderProducts.get(i).getProductId();
//            result = allProducts.stream()
//                    .filter(p -> p.getProductId() == OId)
//                    .collect(Collectors.toList());
//        }
//
//        return result;

        return null;
    }

    @Override
    public List<Customer> getCustomersWhoOrderedProduct(long productId) {
        //To do
        return null;
    }

    @Override
    public Product getMaxOrderedProduct() {
        //To do
        return null;

    }
    @Override
    public double sumOfOrder(long orderID) {
        return allOrders.stream()
                .filter(op -> op.getOrderId() == orderID)
                .count();
    }

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
