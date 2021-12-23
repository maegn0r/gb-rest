package ru.gb.gbrest.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbrest.dto.OrderDto;
import ru.gb.gbrest.dto.ProductDto;
import ru.gb.gbrest.service.feign.OrderDtoApi;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderDtoApi orderDtoApi;

    @PostMapping
    public OrderDto create(@RequestBody List<ProductDto> products, @RequestParam String address) {
        return orderDtoApi.create(products, address);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        return orderDtoApi.deleteOrder(id);
    }

    @PutMapping("/add_to_order/{id}")
    public OrderDto addToOrder(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return orderDtoApi.addToOrder(id, productDto);
    }

    @PutMapping("/remove_from_order/{id}")
    public OrderDto removeFromOrder(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return orderDtoApi.removeFromOrder(id, productDto);
    }
}
