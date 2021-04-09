package ro.msg.learning.shop.Repositories;

import org.springframework.data.repository.CrudRepository;
import ro.msg.learning.shop.Entities.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {
}
