package com.soaint.shoppingcart.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private Float price;
}
