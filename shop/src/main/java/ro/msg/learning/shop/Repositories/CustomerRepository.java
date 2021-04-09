package ro.msg.learning.shop.Repositories;

import org.springframework.data.repository.CrudRepository;
import ro.msg.learning.shop.Entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
