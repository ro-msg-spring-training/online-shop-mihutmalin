package ro.msg.learning.shop.Repositories;

import org.springframework.data.repository.CrudRepository;
import ro.msg.learning.shop.Entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
