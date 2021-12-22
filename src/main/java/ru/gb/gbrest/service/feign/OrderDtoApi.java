package ru.gb.gbrest.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.gbrest.dto.OrderDto;
import ru.gb.gbrest.dto.ProductDto;

import java.util.List;


@FeignClient(url = "localhost:8456/orders", value = "OrderDtoApi")
public interface OrderDtoApi {

        @PostMapping(produces = "application/json;charset=UTF-8",
                consumes = "application/json;charset=UTF-8")
        OrderDto create(@RequestBody List<ProductDto> products, @RequestParam String address);
    }
