package ro.msg.learning.shop.Services;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Entities.*;
import ro.msg.learning.shop.Strategies.StrategyConfigurationInterface;
import ro.msg.learning.shop.DTOs.*;
import ro.msg.learning.shop.Repositories.*;
import ro.msg.learning.shop.Utility.Mapper;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CustomerRepository customerRepository;
    private final StrategyConfigurationInterface strategy;

    @Transactional
    public ArrayList<OrderDTO> create(InputDTO inputDTO){
        ArrayList<OrderDTO> result = new ArrayList<>();

        ArrayList<StrategyDTO> list = (ArrayList<StrategyDTO>)strategy.doStrategy(inputDTO);

        Customer customer = customerRepository.findById(inputDTO.getCustomerId()).get();
        Address address = Mapper.convertAddressDTOToAddress(inputDTO.getAddressDTO());

        boolean single = true;
        LocationDTO firstLocationDTO = list.get(0).getLocation();
        for(StrategyDTO strategyDTO : list) {
            if (!strategyDTO.getLocation().getId().equals(firstLocationDTO.getId())) {
                single = false;
                break;
            }
        }

        if(single){
            Order order = Order.builder()
                    .shippedFrom(Mapper.convertLocationDTOToLocation(firstLocationDTO))
                    .customer(customer)
                    .createDate(inputDTO.getCreateDate())
                    .address(address)
                    .build();
            orderRepository.save(order);
            result.add(Mapper.convertOrderToOrderDTO(order));
            for(StrategyDTO strategy : list){
                OrderDetailId orderDetailId = OrderDetailId.builder()
                        .idOrder(order.getId())
                        .idProduct(strategy.getProduct().getId())
                        .build();
                OrderDetail orderDetail = OrderDetail.builder()
                        .orderDetailId(orderDetailId)
                        .product(Mapper.convertProductDTOToProduct(strategy.getProduct()))
                        .order(order)
                        .quantity(strategy.getQuantity())
                        .build();
                orderDetailRepository.save(orderDetail);
            }
        }
        else{
            for(StrategyDTO strategy : list){
                LocationDTO multipleLocationDTO = strategy.getLocation();
                Order order = null;
                for(StrategyDTO strategy2 : list) {
                    if(multipleLocationDTO == strategy2.getLocation()) {
                        order = Order.builder()
                                .shippedFrom(Mapper.convertLocationDTOToLocation(multipleLocationDTO))
                                .customer(customer)
                                .createDate(inputDTO.getCreateDate())
                                .address(address)
                                .build();
                        orderRepository.save(order);
                        result.add(Mapper.convertOrderToOrderDTO(order));
                    }
                }
                OrderDetailId orderDetailId = OrderDetailId.builder()
                        .idOrder(order.getId())
                        .idProduct(strategy.getProduct().getId())
                        .build();
                OrderDetail orderDetail = OrderDetail.builder()
                        .orderDetailId(orderDetailId)
                        .product(Mapper.convertProductDTOToProduct(strategy.getProduct()))
                        .order(order)
                        .quantity(strategy.getQuantity())
                        .build();
                orderDetailRepository.save(orderDetail);
            }
        }

        return result;
    }

    public OrderDTO update(Long id, OrderDTO orderDTO) throws NotFoundException {
        orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The order with id:" + id.toString() + " not found"));

        orderRepository.save(Mapper.convertOrderDTOToOrder(orderDTO));
        return orderDTO;
    }

    public void delete(Long id){
        orderRepository.deleteById(id);
    }

    public OrderDTO readById(Long Id){
        return Mapper.convertOrderToOrderDTO(orderRepository.findById(Id).get());
    }

    public List<OrderDTO> readAll() {
        return orderRepository
                .findAll()
                .stream()
                .map(Mapper::convertOrderToOrderDTO)
                .collect(Collectors.toList());
    }
}
