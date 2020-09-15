package com.soaint.shoppingcart.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SaleDetailDto {
    private Long id;
    private Long saletId;
    private Long productId;
}
