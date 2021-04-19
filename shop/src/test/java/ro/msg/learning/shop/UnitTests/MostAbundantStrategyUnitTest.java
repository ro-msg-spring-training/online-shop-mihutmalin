package ro.msg.learning.shop.UnitTests;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import ro.msg.learning.shop.DTOs.AddressDTO;
import ro.msg.learning.shop.DTOs.InputDTO;
import ro.msg.learning.shop.DTOs.ProductIdAndQuantityDTO;
import ro.msg.learning.shop.Entities.*;
import ro.msg.learning.shop.Exceptions.MostAbundantException;
import ro.msg.learning.shop.Exceptions.SingleLocationException;
import ro.msg.learning.shop.Repositories.LocationRepository;
import ro.msg.learning.shop.Repositories.StockRepository;
import ro.msg.learning.shop.Strategies.MostAbundantStrategyConfiguration;
import ro.msg.learning.shop.Strategies.SingleLocationStrategyConfiguration;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class MostAbundantStrategyUnitTest {
    @InjectMocks
    private MostAbundantStrategyConfiguration strategy;

    @Mock
    private StockRepository stockRepository;

    private InputDTO inputDTO;
    private ArrayList<Stock> stocks1 = new ArrayList<Stock>();
    private ArrayList<Stock> stocks2 = new ArrayList<Stock>();

    @BeforeEach
    void initUseCase() {
        //INPUT
        AddressDTO addressDTO = AddressDTO.builder()
                .id(1L)
                .country("Country1")
                .city("City1")
                .county("County1")
                .streetAddress("StreetAddress1")
                .build();

        List<ProductIdAndQuantityDTO> products = new ArrayList<>();
        ProductIdAndQuantityDTO productIdAndQuantityDTO1 = ProductIdAndQuantityDTO.builder()
                .productId(1L)
                .quantity(1)
                .build();
        products.add(productIdAndQuantityDTO1);
        ProductIdAndQuantityDTO productIdAndQuantityDTO2 = ProductIdAndQuantityDTO.builder()
                .productId(2L)
                .quantity(1)
                .build();
        products.add(productIdAndQuantityDTO2);

        inputDTO = InputDTO.builder()
                .createDate(new Date(System.currentTimeMillis()))
                .addressDTO(addressDTO)
                .products(products)
                .customerId(1L)
                .build();

        //LOCATION
        Address address1 = Address.builder()
                .country("Country2")
                .city("City2")
                .county("County2")
                .streetAddress("StreetAddress2")
                .build();
        address1.setId(2L);
        Address address2 = Address.builder()
                .country("Country3")
                .city("City3")
                .county("County3")
                .streetAddress("StreetAddress3")
                .build();
        address2.setId(3L);

        List<Location> locations = new ArrayList<>();
        Location location1 = Location.builder()
                .name("Depot1")
                .address(address1)
                .build();
        location1.setId(1L);
        Location location2 = Location.builder()
                .name("Depot2")
                .address(address2)
                .build();
        location1.setId(2L);
        locations.add(location2);

        //STOCK
        ProductCategory productCategory1 = ProductCategory.builder()
                .name("ProductCategory1")
                .description("")
                .build();
        productCategory1.setId(1L);

        Supplier supplier = Supplier.builder()
                .name("Supplier")
                .build();
        supplier.setId(1L);

        Product product1 = Product.builder()
                .name("Product1")
                .description("")
                .price(10)
                .weight(5)
                .category(productCategory1)
                .supplier(supplier)
                .imageUrl("")
                .build();
        product1.setId(1L);

        Product product2 = Product.builder()
                .name("Product2")
                .description("")
                .price(100)
                .weight(50)
                .category(productCategory1)
                .supplier(supplier)
                .imageUrl("")
                .build();
        product1.setId(2L);

        StockId stockId1 = StockId.builder().idLocation(1L).idProduct(1L).build();
        Stock stock1 = Stock.builder()
                .id(stockId1)
                .product(product1)
                .location(location1)
                .quantity(5)
                .build();
        StockId stockId2 = StockId.builder().idLocation(2L).idProduct(2L).build();
        Stock stock2 = Stock.builder()
                .id(stockId2)
                .product(product2)
                .location(location2)
                .quantity(15)
                .build();

        stocks1.add(stock1);
        stocks2.add(stock2);

    }

    @Test
    public void canApplyStrategy() {
        Mockito.when(stockRepository.findStockByProductIdOrderByQuantityDesc(inputDTO.getProducts().get(0).getProductId())).thenReturn(stocks1);
        Mockito.when(stockRepository.findStockByProductIdOrderByQuantityDesc(inputDTO.getProducts().get(1).getProductId())).thenReturn(stocks2);

        assertFalse(strategy.doStrategy(inputDTO).isEmpty());
    }

    @Test
    public void canNotApplyStrategy() {
        try {
            Mockito.when(stockRepository.findStockByProductIdOrderByQuantityDesc(inputDTO.getProducts().get(0).getProductId())).thenReturn(new ArrayList<Stock>());
            strategy.doStrategy(inputDTO);
        } catch (MostAbundantException e) {
            MatcherAssert.assertThat(e.getMessage(), is("Cannot apply MostAbundantStrategy"));
        }
    }
}
