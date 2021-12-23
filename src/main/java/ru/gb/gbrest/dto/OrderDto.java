package ru.gb.gbrest.dto;

import lombok.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private String address;
    private List<OrderItemDto> orderItems;

}
