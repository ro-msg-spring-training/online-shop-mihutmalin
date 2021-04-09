package ro.msg.learning.shop.Repositories;

import org.springframework.data.repository.CrudRepository;
import ro.msg.learning.shop.Entities.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
}
