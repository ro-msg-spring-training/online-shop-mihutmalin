package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Entities.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
