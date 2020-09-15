package com.soaint.shoppingcart.service;

import com.soaint.shoppingcart.dto.ClientDto;
import rx.Single;

import java.util.List;

/**
 * Service interface for the Client entity.
 */
public interface ClientService {

    ClientDto save(ClientDto clientDto);

    List<ClientDto> findAll();

    Single<Object> findAllById(Long id);
}
