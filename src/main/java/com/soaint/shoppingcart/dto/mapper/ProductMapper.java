package com.soaint.shoppingcart.dto.mapper;

import com.soaint.shoppingcart.domain.Product;
import com.soaint.shoppingcart.dto.ProductDto;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity Product and its DTO ProductDto.
 */
@Mapper( componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDto, Product> {

}
