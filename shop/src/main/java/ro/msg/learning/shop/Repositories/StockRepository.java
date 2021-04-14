package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.msg.learning.shop.Entities.Stock;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query("SELECT s FROM Stock s where s.product.id = :idProduct and s.location.id = :idLocation")
    Stock findByProductId(@Param("idProduct") Long idProduct, @Param("idProduct") Long idLocation);
}
