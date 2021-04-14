package ro.msg.learning.shop.Configurations;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.Strategies.MostAbundantStrategyConfiguration;
import ro.msg.learning.shop.Strategies.SingleLocationStrategyConfiguration;
import ro.msg.learning.shop.Strategies.StrategyConfigurationInterface;

@Configuration
@AllArgsConstructor
public class StrategyConfiguration {

    @Bean
    public StrategyConfigurationInterface chooseStrategy(@Value("${strategy}")String s) throws Exception {
        if(s.equals("SingleLocationStrategy")){
            return new SingleLocationStrategyConfiguration();
        }
        else if(s.equals("MostAbundantStrategy")){
            return new MostAbundantStrategyConfiguration();
        }
        else{
            throw new RuntimeException("Invalid Strategy");
        }
    }
}
