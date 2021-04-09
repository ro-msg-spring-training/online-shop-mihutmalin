package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
