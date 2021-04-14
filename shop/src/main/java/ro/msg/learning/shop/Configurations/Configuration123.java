package ro.msg.learning.shop.Configurations;

import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuration123 {
    //@Value("${strategy.name}")
    private String s = "SingleLocationStrategy";

    @Bean
    public StrategyConfiguration chooseStrategy() throws Exception {
        if(this.s == "SingleLocationStrategy"){
            return new SingleLocationStrategyConfiguration();
        }
        else if(this.s == "MostAbundantStrategy"){
            return new MostAbundantStrategyConfiguration();
        }
        else{
            throw new Exception();
        }
    }
}
