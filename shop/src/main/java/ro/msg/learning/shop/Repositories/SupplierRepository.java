package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
