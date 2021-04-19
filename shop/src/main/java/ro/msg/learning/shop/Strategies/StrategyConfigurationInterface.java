package ro.msg.learning.shop.Strategies;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTOs.InputDTO;
import ro.msg.learning.shop.DTOs.StrategyDTO;

import java.util.List;

@Component
public interface StrategyConfigurationInterface {
    public List<StrategyDTO> doStrategy(InputDTO inputDTO);
}
