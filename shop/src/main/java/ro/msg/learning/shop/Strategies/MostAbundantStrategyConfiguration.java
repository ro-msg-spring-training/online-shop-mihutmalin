package ro.msg.learning.shop.Strategies;

import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.DTOs.InputDTO;
import ro.msg.learning.shop.DTOs.ProductIdAndQuantityDTO;
import ro.msg.learning.shop.DTOs.StrategyDTO;
import ro.msg.learning.shop.Entities.Location;
import ro.msg.learning.shop.Entities.Stock;
import ro.msg.learning.shop.Entities.StockId;
import ro.msg.learning.shop.Exceptions.MostAbundantException;
import ro.msg.learning.shop.Repositories.LocationRepository;
import ro.msg.learning.shop.Repositories.StockRepository;
import ro.msg.learning.shop.Utility.Mapper;

import java.util.ArrayList;
import java.util.List;

public class MostAbundantStrategyConfiguration implements StrategyConfigurationInterface {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<StrategyDTO> doStrategy(InputDTO inputDTO) {
        ArrayList<StrategyDTO> result = new ArrayList<>();

        for(ProductIdAndQuantityDTO product : inputDTO.getProducts()){
            ArrayList<Stock> stock = (ArrayList<Stock>)stockRepository
                    .findStockByProductIdOrderByQuantityDesc(product.getProductId());
            if(stock.isEmpty()){
                break;
            }
            StrategyDTO strategyDTO = StrategyDTO.builder()
                    .location(Mapper.convertLocationToLocationDTO(stock.get(0).getLocation()))
                    .product(Mapper.convertProductToProductDTO(stock.get(0).getProduct()))
                    .quantity(product.getQuantity())
                    .build();

            result.add(strategyDTO);

            if (stock.get(0).getQuantity() < product.getQuantity()) {
                result.clear();
                break;
            }
            stock.get(0).setQuantity(stock.get(0).getQuantity()- product.getQuantity());
            stockRepository.save(stock.get(0));
        }
        if(result.isEmpty())
            throw new MostAbundantException();

        return result;
    }
}
