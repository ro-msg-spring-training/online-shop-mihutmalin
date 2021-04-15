package ro.msg.learning.shop.Strategies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.DTOs.*;
import ro.msg.learning.shop.Entities.Location;
import ro.msg.learning.shop.Entities.Stock;
import ro.msg.learning.shop.Entities.StockId;
import ro.msg.learning.shop.Exceptions.SingleLocationException;
import ro.msg.learning.shop.Repositories.LocationRepository;
import ro.msg.learning.shop.Repositories.StockRepository;
import ro.msg.learning.shop.Utility.Mapper;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleLocationStrategyConfiguration implements StrategyConfigurationInterface {
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<StrategyDTO> doStrategy(InputDTO inputDTO) {
        ArrayList<StrategyDTO> result = new ArrayList<>();

        ArrayList<Location> locations = (ArrayList<Location>)locationRepository.findAll();

        boolean bad = false;
        for(Location location : locations){
            for(ProductIdAndQuantityDTO product : inputDTO.getProducts()){

                StockId stockId = new StockId(product.getProductId(), location.getId());
                if(stockRepository.findById(stockId).isEmpty()){
                    result.clear();
                    bad = true;
                    break;
                }
                else {
                    Stock stock = stockRepository.findById(stockId).get();

                    StrategyDTO strategyDTO = StrategyDTO.builder()
                            .location(Mapper.convertLocationToLocationDTO(stock.getLocation()))
                            .product(Mapper.convertProductToProductDTO(stock.getProduct()))
                            .quantity(product.getQuantity())
                            .build();

                    result.add(strategyDTO);

                    if (stock.getQuantity() < product.getQuantity()) {
                        result.clear();
                        bad = true;
                        break;
                    }
                    stock.setQuantity(stock.getQuantity()- product.getQuantity());
                    stockRepository.save(stock);
                }

            }

            if(!bad){
                return result;
            }
        }
        if(result.isEmpty())
            throw new SingleLocationException();

        return result;
    }
}
