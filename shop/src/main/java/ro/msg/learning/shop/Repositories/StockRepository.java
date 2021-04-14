package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.msg.learning.shop.Entities.Stock;
import ro.msg.learning.shop.Entities.StockId;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, StockId> {
    List<Stock> findStockByProductIdOrderByQuantityDesc(Long idProduct);
}
