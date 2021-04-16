package ro.msg.learning.shop.Controllers;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.DTOs.InputDTO;
import ro.msg.learning.shop.DTOs.OrderDTO;
import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.Services.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<InputDTO> create(@RequestBody InputDTO inputDTO) {
        if(orderService.create(inputDTO) == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PutMapping("/orders/{id}")
    public OrderDTO update(@PathVariable long id, @RequestBody OrderDTO orderDTO) throws NotFoundException {
        return orderService.update(id, orderDTO);
    }

    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }

    @GetMapping("/orders/{id}")
    public OrderDTO readByd(@PathVariable Long id) {
        return orderService.readById(id);
    }

    @GetMapping("/orders")
    public List<OrderDTO> readAll() {
        return orderService.readAll();
    }
}
