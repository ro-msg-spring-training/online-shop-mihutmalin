package ro.msg.learning.shop.Repositories;

import org.springframework.data.repository.CrudRepository;
import ro.msg.learning.shop.Entities.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
