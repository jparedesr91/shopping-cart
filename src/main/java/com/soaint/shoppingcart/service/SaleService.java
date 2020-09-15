package com.soaint.shoppingcart.service;

import com.soaint.shoppingcart.dto.ProductDto;
import com.soaint.shoppingcart.dto.SaleDto;
import rx.Single;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for the Sale entity.
 */
public interface SaleService {

    SaleDto save(SaleDto clientDto);

    List<SaleDto> findAll();

    Optional<SaleDto> findOne(Long id);

    Single<List<SaleDto>> findAllSalesById(Long id);

    SaleDto createSaleDetail(Long clientId, List<ProductDto> products);
}
