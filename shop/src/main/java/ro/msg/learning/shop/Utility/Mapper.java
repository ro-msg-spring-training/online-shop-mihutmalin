package ro.msg.learning.shop.Utility;

import lombok.experimental.UtilityClass;
import ro.msg.learning.shop.DTOs.*;
import ro.msg.learning.shop.Entities.*;

@UtilityClass
public class Mapper {
    /////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////// PRODUCT ///////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    public ProductDTO convertProductToProductDTO(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .weight(product.getWeight())
                .productCategory(convertProductCategoryToProductCategoryDTO(product.getCategory()))
                .supplier(convertSupplierToSupplierDTO(product.getSupplier()))
                .imageUrl(product.getImageUrl()).build();
    }

    public Product convertProductDTOToProduct(ProductDTO productDTO){
        Product product = Product.builder().
                name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .weight(productDTO.getWeight())
                .category(convertProductCategoryDTOToProductCategory(productDTO.getProductCategory()))
                .supplier(convertSupplierDTOToSupplier(productDTO.getSupplier()))
                .imageUrl(productDTO.getImageUrl()).build();
        product.setId(productDTO.getId());
        return product;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////// ORDER /////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    public OrderDTO convertOrderToOrderDTO(Order order){
        return OrderDTO.builder()
                .id(order.getId())
                .shippedFrom(convertLocationToLocationDTO(order.getShippedFrom()))
                .customer(convertCustomerToCustomerDTO(order.getCustomer()))
                .createDate(order.getCreateDate())
                .address(convertAddressToAddressDTO(order.getAddress()))
                .build();
    }

    public Order convertOrderDTOToOrder(OrderDTO orderDTO){
        Order order = Order.builder()
                .shippedFrom(convertLocationDTOToLocation(orderDTO.getShippedFrom()))
                .customer(convertCustomerDTOToCustomer(orderDTO.getCustomer()))
                .createDate(orderDTO.getCreateDate())
                .address(convertAddressDTOToAddress(orderDTO.getAddress()))
                .build();
        order.setId(orderDTO.getId());
        return order;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////// LOCATION ///////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    public LocationDTO convertLocationToLocationDTO(Location location){
        return LocationDTO.builder()
                .id(location.getId())
                .name(location.getName())
                .address(convertAddressToAddressDTO(location.getAddress()))
                .build();
    }

    public Location convertLocationDTOToLocation(LocationDTO locationDTO){
        Location location = Location.builder()
                .name(locationDTO.getName())
                .address(convertAddressDTOToAddress(locationDTO.getAddress()))
                .build();
        location.setId(locationDTO.getId());
        return location;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////// Customer ///////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    public CustomerDTO convertCustomerToCustomerDTO(Customer customer){
        return CustomerDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .username(customer.getUsername())
                .password(customer.getPassword())
                .emailAddress(customer.getEmailAddress())
                .build();
    }

    public Customer convertCustomerDTOToCustomer(CustomerDTO customerDTO){
        Customer customer =  Customer.builder()
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .username(customerDTO.getUsername())
                .password(customerDTO.getPassword())
                .emailAddress(customerDTO.getEmailAddress())
                .build();
        customer.setId(customerDTO.getId());
        return customer;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////// SUPPLIER ///////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    public SupplierDTO convertSupplierToSupplierDTO(Supplier supplier){
        return SupplierDTO.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .build();
    }

    public Supplier convertSupplierDTOToSupplier(SupplierDTO supplierDTO){
        Supplier supplier = Supplier.builder()
                .name(supplierDTO.getName())
                .build();
        supplier.setId(supplierDTO.getId());
        return supplier;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////// PRODUCT CATEGORY //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    public ProductCategoryDTO convertProductCategoryToProductCategoryDTO(ProductCategory productCategory){
        return ProductCategoryDTO.builder()
                .id(productCategory.getId())
                .name(productCategory.getName())
                .description(productCategory.getDescription())
                .build();
    }

    public ProductCategory convertProductCategoryDTOToProductCategory(ProductCategoryDTO productCategoryDTO){
        ProductCategory productCategory = ProductCategory.builder()
                .name(productCategoryDTO.getName())
                .description(productCategoryDTO.getDescription())
                .build();
        productCategory.setId(productCategoryDTO.getId());
        return productCategory;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////// ADDRESS ///////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    public AddressDTO convertAddressToAddressDTO(Address address){
        return AddressDTO.builder()
                .id(address.getId())
                .country(address.getCountry())
                .city(address.getCity())
                .county(address.getCounty())
                .streetAddress(address.getStreetAddress())
                .build();
    }

    public Address convertAddressDTOToAddress(AddressDTO addressDTO){
        Address address =  Address.builder().
                country(addressDTO.getCountry())
                .city(addressDTO.getCity())
                .county(addressDTO.getCounty())
                .streetAddress(addressDTO.getStreetAddress())
                .build();
        address.setId(addressDTO.getId());
        return address;
    }
}
