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
import ro.msg.learning.shop.Exceptions.SingleLocationException;
import ro.msg.learning.shop.Repositories.LocationRepository;
import ro.msg.learning.shop.Repositories.StockRepository;
import ro.msg.learning.shop.Strategies.SingleLocationStrategyConfiguration;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class LocationStrategyUnitTest {
    @InjectMocks
    private SingleLocationStrategyConfiguration strategy;

    @Mock
    private StockRepository stockRepository;

    @Mock
    private LocationRepository locationRepository;

    private StockId stockId;
    private Stock stock;
    private InputDTO inputDTO;

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

        inputDTO = InputDTO.builder()
                .createDate(new Date(System.currentTimeMillis()))
                .addressDTO(addressDTO)
                .products(products)
                .customerId(1L)
                .build();

        //LOCATION
        Address address = Address.builder()
                .country("Country2")
                .city("City2")
                .county("County2")
                .streetAddress("StreetAddress2")
                .build();
        address.setId(1L);

        List<Location> locations = new ArrayList<>();
        Location location1 = Location.builder()
                .name("Depot1")
                .address(address)
                .build();
        location1.setId(1L);
        locations.add(location1);

        Mockito.when(locationRepository.findAll()).thenReturn(locations);

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

        stockId = StockId.builder().idLocation(1L).idProduct(1L).build();
        stock = Stock.builder()
                .id(stockId)
                .product(product1)
                .location(location1)
                .quantity(5)
                .build();
    }

    @Test
    public void canApplyStrategy() {
        Mockito.when(stockRepository.findById(stockId)).thenReturn(Optional.of(stock));
        assertFalse(strategy.doStrategy(inputDTO).isEmpty());
    }

    @Test
    public void canNotApplyStrategy() {
        try {
            Mockito.when(stockRepository.findById(stockId)).thenReturn(Optional.empty());
            strategy.doStrategy(inputDTO);
        } catch (SingleLocationException e) {
            MatcherAssert.assertThat(e.getMessage(), is("Cannot apply SingleLocationStrategy"));
        }
    }
}
