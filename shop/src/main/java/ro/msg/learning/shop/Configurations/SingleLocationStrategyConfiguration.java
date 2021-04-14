package ro.msg.learning.shop.Configurations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import ro.msg.learning.shop.DTOs.*;
import ro.msg.learning.shop.Entities.Location;
import ro.msg.learning.shop.Entities.Stock;
import ro.msg.learning.shop.Repositories.ProductRepository;
import ro.msg.learning.shop.Repositories.LocationRepository;
import ro.msg.learning.shop.Repositories.StockRepository;
import ro.msg.learning.shop.Utility.Mapper;

import java.util.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleLocationStrategyConfiguration implements StrategyConfiguration {
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
                Stock stock = stockRepository.findByProductId(product.getProductId(), location.getId());

                StrategyDTO strategyDTO = StrategyDTO.builder()
                        .location(Mapper.convertLocationToLocationDTO(stock.getLocation()))
                        .product(Mapper.convertProductToProductDTO(stock.getProduct()))
                        .quantity(stock.getQuantity())
                        .build();

                result.add(strategyDTO);

                if (stock.getQuantity() < product.getQuantity()) {
                    result.clear();
                    bad = true;
                    break;
                }
            }

            if(!bad){
                return result;
            }
        }

        return result;
    }
}
