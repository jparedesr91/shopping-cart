package com.soaint.shoppingcart.dto.mapper;

import com.soaint.shoppingcart.domain.Client;
import com.soaint.shoppingcart.dto.ClientDto;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity Client and its DTO ClientDTO.
 */
@Mapper( componentModel = "spring")
public interface ClientMapper extends EntityMapper<ClientDto, Client> {

}
