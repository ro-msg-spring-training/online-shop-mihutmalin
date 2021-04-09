package ro.msg.learning.shop.Repositories;

import org.springframework.data.repository.CrudRepository;
import ro.msg.learning.shop.Entities.ProductCategory;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {
}
