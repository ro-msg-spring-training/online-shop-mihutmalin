package ro.msg.learning.shop.Repositories;

import org.springframework.data.repository.CrudRepository;
import ro.msg.learning.shop.Entities.Stock;

public interface StockRepository extends CrudRepository<Stock, Long> {
}
