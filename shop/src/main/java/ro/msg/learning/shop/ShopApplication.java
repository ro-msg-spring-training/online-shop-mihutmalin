package ro.msg.learning.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.msg.learning.shop.Configurations.SingleLocationStrategyConfiguration;
import ro.msg.learning.shop.Configurations.StrategyConfiguration;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
		/*
		ApplicationContext ctx = new AnnotationConfigApplicationContext(StrategyConfiguration.class);

		StrategyConfiguration strategy = ctx.getBean(StrategyConfiguration.class);
		strategy.doSingleLocation();
		strategy.doMostAbundant();
		 */
	}

}
