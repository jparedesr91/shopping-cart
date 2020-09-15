package com.soaint.shoppingcart.service.impl;


import com.soaint.shoppingcart.domain.Client;
import com.soaint.shoppingcart.dto.ClientDto;
import com.soaint.shoppingcart.dto.mapper.ClientMapper;
import com.soaint.shoppingcart.errors.dto.MyError;
import com.soaint.shoppingcart.repository.ClientRepository;
import com.soaint.shoppingcart.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rx.Single;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service implementation for the Client entity.
 */
@Service
@Transactional
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    /**
     * Save a client.
     *
     * @param clientDto the entity to save
     * @return the persisted entity
     */
    public ClientDto save(ClientDto clientDto) {
        log.debug("Request to save Client : {}", clientDto);
        Client client = clientMapper.toEntity(clientDto);
        client = clientRepository.save(client);
        return clientMapper.toDto(client);
    }


    /**
     * Get all clients.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<ClientDto> findAll() {
        log.debug("Request to get all clients");
        return clientRepository.findAll().stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get all clients by id.
     * @param id
     * @return Optional of Client
     */
    @Transactional(readOnly = true)
    public Single<Object> findAllById(Long id) {
        log.debug("Request to get all clients by Id");
        return Single.create(singleSubscriber ->{
            final Optional<ClientDto> optionalClient = clientRepository.findById(id).map(clientMapper::toDto);
            if (!optionalClient.isPresent()){
                singleSubscriber.onError(new MyError(HttpStatus.NO_CONTENT,
                        204,
                        "no se encontró el campo por ese id",
                        ""));
                throw new EntityNotFoundException("no se encontró el campo por ese id");

            }else {
                singleSubscriber.onSuccess(optionalClient);
            }
        });
    }


}
