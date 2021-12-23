package ru.gb.gbrest.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbrest.dto.OrderDto;
import ru.gb.gbrest.dto.ProductDto;

import java.util.List;


@FeignClient(url = "localhost:8456/orders", value = "OrderDtoApi")
public interface OrderDtoApi {

    @PostMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    OrderDto create(@RequestBody List<ProductDto> products, @RequestParam String address);


    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteOrder(@PathVariable Long id);

    @PutMapping("/add_to_order/{id}")
    OrderDto addToOrder(@PathVariable Long id, @RequestBody ProductDto productDto);

    @PutMapping("/remove_from_order/{id}")
    OrderDto removeFromOrder(@PathVariable Long id, @RequestBody ProductDto productDto);
    }
