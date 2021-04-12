package ro.msg.learning.shop.Controllers;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.Entities.Product;
import ro.msg.learning.shop.Services.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    @ResponseBody
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        return productService.create(productDTO);
    }

    @PutMapping("/products/{id}")
    public ProductDTO update(@PathVariable long id, @RequestBody ProductDTO productDTO) throws NotFoundException {
        return productService.update(id, productDTO);
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("/products/{id}")
    public ProductDTO readByd(@PathVariable Long id) {
        return productService.readById(id);
    }

    @GetMapping("/products")
    public List<ProductDTO> readAll() {
        return productService.readAll();
    }

}
