package ro.msg.learning.shop.Controllers;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.Entities.Product;
import ro.msg.learning.shop.Services.ProductService;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ProductDTO create(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping("/update/{id}")
    public ProductDTO update(@PathVariable long id, @RequestBody Product product) throws NotFoundException {
        return productService.update(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("/readById/{id}")
    public ProductDTO readByd(@PathVariable Long id) {
        return productService.readById(id);
    }

    @GetMapping("/readAll")
    public List<ProductDTO> readAll() {
        return productService.readAll();
    }
}
