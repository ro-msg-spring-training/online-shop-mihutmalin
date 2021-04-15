package ro.msg.learning.shop.IntegrationTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ro.msg.learning.shop.DTOs.AddressDTO;
import ro.msg.learning.shop.DTOs.InputDTO;
import ro.msg.learning.shop.DTOs.OrderDTO;
import ro.msg.learning.shop.DTOs.ProductIdAndQuantityDTO;
import ro.msg.learning.shop.Entities.*;
import ro.msg.learning.shop.Exceptions.SingleLocationException;
import ro.msg.learning.shop.Repositories.*;
import ro.msg.learning.shop.Services.OrderService;
import ro.msg.learning.shop.ShopApplication;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ShopApplication.class)
public class CreateOrderIntegrationTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void createOrderSuccessfully() {
        AddressDTO addressDTO = AddressDTO.builder()
                .id(1L)
                .country("Romania")
                .city("Cluj-Napoca")
                .county("Cluj")
                .streetAddress("str. Lalelelor, nr. 22")
                .build();

        List<ProductIdAndQuantityDTO> products = new ArrayList<>();
        ProductIdAndQuantityDTO productIdAndQuantityDTO1 = ProductIdAndQuantityDTO.builder()
                .productId(1L)
                .quantity(1)
                .build();
        ProductIdAndQuantityDTO productIdAndQuantityDTO2 = ProductIdAndQuantityDTO.builder()
                .productId(2L)
                .quantity(1)
                .build();
        products.add(productIdAndQuantityDTO1);
        products.add(productIdAndQuantityDTO2);

        InputDTO inputDTO = InputDTO.builder()
                .createDate(new Date(System.currentTimeMillis()))
                .addressDTO(addressDTO)
                .products(products)
                .customerId(1L)
                .build();

        ArrayList<OrderDTO> orders = this.orderService.create(inputDTO);

        assertFalse(orders.isEmpty());
    }

    @Test(expected = SingleLocationException.class)
    public void createOrderUnsuccessfully() {
        AddressDTO addressDTO = AddressDTO.builder()
                .id(2L)
                .country("Romania")
                .city("Cluj-Napoca")
                .county("Cluj")
                .streetAddress("str. Lalelelor, nr. 22")
                .build();

        List<ProductIdAndQuantityDTO> products = new ArrayList<>();
        ProductIdAndQuantityDTO productIdAndQuantityDTO1 = ProductIdAndQuantityDTO.builder()
                .productId(1L)
                .quantity(1)
                .build();
        ProductIdAndQuantityDTO productIdAndQuantityDTO2 = ProductIdAndQuantityDTO.builder()
                .productId(3L)
                .quantity(1)
                .build();
        products.add(productIdAndQuantityDTO1);
        products.add(productIdAndQuantityDTO2);

        InputDTO inputDTO = InputDTO.builder()
                .createDate(new Date(System.currentTimeMillis()))
                .addressDTO(addressDTO)
                .products(products)
                .customerId(1L)
                .build();

        ArrayList<OrderDTO> orders = this.orderService.create(inputDTO);
    }


}
