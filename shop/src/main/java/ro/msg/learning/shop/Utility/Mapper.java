package ro.msg.learning.shop.Utility;

import lombok.experimental.UtilityClass;
import ro.msg.learning.shop.DTOs.AddressDTO;
import ro.msg.learning.shop.DTOs.OrderDTO;
import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.Entities.*;

@UtilityClass
public class Mapper {

    public ProductDTO convertProductToProductDTO(Product product){
        return ProductDTO.builder().id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .weight(product.getWeight())
                .idCategory(product.getCategory().getId())
                .nameCategory(product.getCategory().getName())
                .descriptionCategory(product.getCategory().getDescription())
                .idSupplier(product.getSupplier().getId())
                .nameSupplier(product.getSupplier().getName())
                .imageUrl(product.getImageUrl()).build();
    }

    public Product convertProductDTOToProduct(ProductDTO productDTO){
        ProductCategory productCategory = ProductCategory.builder().name(productDTO.getNameCategory())
                .description(productDTO.getDescriptionCategory())
                .build();
        productCategory.setId(productDTO.getIdCategory());
        Supplier supplier = Supplier.builder().name(productDTO.getNameSupplier())
                .build();
        supplier.setId(productDTO.getIdSupplier());

        return Product.builder().name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .weight(productDTO.getWeight())
                .category(productCategory)
                .supplier(supplier)
                .imageUrl(productDTO.getImageUrl()).build();
    }

    public Order convertOrderDTOToOrder(OrderDTO orderDTO, String firstName, String lastName, String username, String password,
                                  String emailAddress){
        Customer customer = Customer.builder().firstName(firstName)
                .lastName(lastName)
                .username(username)
                .password(password)
                .emailAddress(emailAddress)
                .build();
        customer.setId(orderDTO.getCustomerId());

        return Order.builder().shippedFrom(new Location())
                .customer(customer)
                .createDate(orderDTO.getCreateDate())
                .address(convertAddressDTOToAddress(orderDTO.getAddressDTO()))
                .build();
    }

    public Address convertAddressDTOToAddress(AddressDTO addressDTO){
        return Address.builder().country(addressDTO.getCountry())
                .city(addressDTO.getCity())
                .county(addressDTO.getCounty())
                .streetAddress(addressDTO.getStreetAddress())
                .build();
    }
}
