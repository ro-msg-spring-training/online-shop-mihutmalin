package ro.msg.learning.shop.Repositories;

import org.springframework.data.repository.CrudRepository;
import ro.msg.learning.shop.Entities.OrderDetail;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long> {
}
