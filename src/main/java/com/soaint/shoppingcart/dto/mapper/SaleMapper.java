package com.soaint.shoppingcart.dto.mapper;

import com.soaint.shoppingcart.domain.Sale;
import com.soaint.shoppingcart.dto.SaleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity Sale and its DTO SaleDto.
 */
@Mapper( componentModel = "spring")
public interface SaleMapper extends EntityMapper<SaleDto, Sale> {

    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "client.name", target = "clientName")
    SaleDto toDto(Sale sale);

    @Mapping(source = "clientId", target = "client.id")
    Sale toEntity(SaleDto saleDTO);

    default Sale fromId(Long id) {
        if (id == null) {
            return null;
        }
        Sale sale = new Sale();
        sale.setId(id);
        return sale;
    }

}
