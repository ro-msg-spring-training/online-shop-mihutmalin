package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Entities.Revenue;

public interface RevenueRepository extends JpaRepository<Revenue, Long> {
}
