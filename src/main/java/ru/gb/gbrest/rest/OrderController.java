package ru.gb.gbrest.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbrest.dto.OrderDto;
import ru.gb.gbrest.dto.ProductDto;
import ru.gb.gbrest.service.feign.OrderDtoApi;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

        private final OrderDtoApi orderDtoApi;

        @PostMapping
        public OrderDto create(@RequestBody List<ProductDto> products, @RequestParam String address) {
            return orderDtoApi.create(products, address);
        }
    }
