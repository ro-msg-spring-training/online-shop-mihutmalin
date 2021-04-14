package ro.msg.learning.shop.Configurations;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTOs.InputDTO;
import ro.msg.learning.shop.DTOs.StrategyDTO;

import java.util.List;

@Component
public interface StrategyConfiguration {
    public List<StrategyDTO> doStrategy(InputDTO inputDTO);
}
