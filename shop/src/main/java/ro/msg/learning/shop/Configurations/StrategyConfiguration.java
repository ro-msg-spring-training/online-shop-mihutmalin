package ro.msg.learning.shop.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StrategyConfiguration {
    @Bean(name="SingleLocation")
    public void doSingleLocation(){
    }

    @Bean(name="MostAbundant")
    public void doMostAbundant(){
    }

}
