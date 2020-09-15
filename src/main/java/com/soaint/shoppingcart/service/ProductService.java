package com.soaint.shoppingcart.service;

import com.soaint.shoppingcart.dto.ProductDto;
import com.soaint.shoppingcart.errors.exceptions.ProductException;

import java.util.List;

/**
 * Service interface for the Client entity.
 */
public interface ProductService {

    ProductDto save(ProductDto productDto) throws ProductException;

    List<ProductDto> findAll() throws ProductException;

    ProductDto findOne(Long id) throws ProductException;

    void delete(Long id) throws ProductException;
}
