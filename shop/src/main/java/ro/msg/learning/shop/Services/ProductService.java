package ro.msg.learning.shop.Services;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.Entities.Product;
import ro.msg.learning.shop.Entities.ProductCategory;
import ro.msg.learning.shop.Repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductDTO create(Product product){
        productRepository.save(product);
        return convertToProductDTO(product);
    }

    public ProductDTO update(Long id, Product product) throws NotFoundException {
        Product searchedProduct = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The product with id:" + id.toString() + " not found"));
        searchedProduct.setName(product.getName());
        searchedProduct.setDescription(product.getDescription());
        searchedProduct.setPrice(product.getPrice());
        searchedProduct.setWeight(product.getWeight());
        searchedProduct.setCategory(product.getCategory());
        searchedProduct.setImageUrl(product.getImageUrl());
        productRepository.save(searchedProduct);
        return convertToProductDTO(searchedProduct);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

    public ProductDTO readById(Long Id){
        return convertToProductDTO(productRepository.findById(Id).get());
    }

    public List<ProductDTO> readAll() {
        return ((List<Product>) productRepository
                .findAll())
                .stream()
                .map(this::convertToProductDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO convertToProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setWeight(product.getWeight());
        productDTO.setCategory(product.getCategory());
        productDTO.setSupplier(product.getSupplier());
        productDTO.setImageUrl(product.getImageUrl());
        return productDTO;
    }
}
