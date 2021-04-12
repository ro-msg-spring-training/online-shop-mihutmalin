package ro.msg.learning.shop.Services;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.Entities.Product;
import ro.msg.learning.shop.Repositories.ProductRepository;
import ro.msg.learning.shop.Utility.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductDTO create(ProductDTO productDTO){
        productRepository.save(Mapper.convertProductDTOToProduct(productDTO));
        return productDTO;
    }

    public ProductDTO update(Long id, ProductDTO productDTO) throws NotFoundException {
        productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The product with id:" + id.toString() + " not found"));

        productRepository.save(Mapper.convertProductDTOToProduct(productDTO));
        return productDTO;
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

    public ProductDTO readById(Long Id){
        return Mapper.convertProductToProductDTO(productRepository.findById(Id).get());
    }

    public List<ProductDTO> readAll() {
        return ((List<Product>) productRepository
                .findAll())
                .stream()
                .map(Mapper::convertProductToProductDTO)
                .collect(Collectors.toList());
    }
}
