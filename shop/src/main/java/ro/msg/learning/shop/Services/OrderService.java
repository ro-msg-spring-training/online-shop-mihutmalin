package ro.msg.learning.shop.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.DTOs.OrderDTO;
import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.DTOs.ProductIdAndQuantityDTO;
import ro.msg.learning.shop.Entities.Customer;
import ro.msg.learning.shop.Entities.Order;
import ro.msg.learning.shop.Entities.OrderDetail;
import ro.msg.learning.shop.Repositories.*;
import ro.msg.learning.shop.Utility.Mapper;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public OrderDTO create(OrderDTO orderDTO){
        Customer customer = customerRepository.findById(orderDTO.getCustomerId()).get();
        Order order = orderRepository.save(Mapper.convertOrderDTOToOrder(orderDTO, customer.getFirstName(), customer.getLastName(),
                customer.getUsername(), customer.getPassword(), customer.getEmailAddress()));
        for(ProductIdAndQuantityDTO product : orderDTO.getProducts()){
            OrderDetail orderDetail = OrderDetail.builder()
                    .product(productRepository.findById(product.getProductId()).get())
                    .order(order)
                    .build();
            orderDetailRepository.save(orderDetail);
        }

        return orderDTO;
    }
}
