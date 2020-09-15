package com.soaint.shoppingcart.service.impl;

import com.soaint.shoppingcart.domain.Client;
import com.soaint.shoppingcart.dto.ClientDto;
import com.soaint.shoppingcart.dto.mapper.ClientMapper;
import com.soaint.shoppingcart.errors.dto.MyError;
import com.soaint.shoppingcart.repository.ClientRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.soaint.shoppingcart.service.impl.TestConstants.CLIENT_ID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {

    @Rule
    public ExpectedException fails = ExpectedException.none();

    @Mock
    ClientRepository clientRepository;
    @Mock
    ClientMapper clientMapper;
    @InjectMocks
    private ClientServiceImpl service;

    Client client = Client.newInstance()
            .id(CLIENT_ID)
            .email("correo@gmail.com")
            .name("correo")
            .lastName("de cuba")
            .dni("dni")
            .phone("000-00000")
            .build();

    ClientDto clientDto = ClientDto.newInstance()
            .id(CLIENT_ID)
            .email("correo@gmail.com")
            .name("correo")
            .lastName("de cuba")
            .dni("dni")
            .phone("000-00000")
            .build();

    @Before
    public void setUp() throws Exception {

        when(clientMapper.toEntity(clientDto)).thenReturn(client);
        when(clientMapper.toDto(client)).thenReturn(clientDto);

        when(clientRepository.save(client)).thenReturn(client);
        when(clientRepository.findAll()).thenReturn(Arrays.asList(client));
    }

    @Test
    public void whenSaveProductAllParamsSet() {

        ClientDto clientdto = service.save(clientDto);

        verify(clientRepository, times(1))
                .save(client);
        verify(clientMapper, times(1))
                .toEntity(clientDto);
        verify(clientMapper, times(1))
                .toDto(client);

        assertEquals(clientdto.getId(), CLIENT_ID);
    }

    @Test
    public void findAll() {

        List<ClientDto> clientDtoList = service.findAll();

        verify(clientRepository, times(1))
                .findAll();

        verify(clientMapper, times(1))
                .toDto(client);

        assertTrue(!clientDtoList.isEmpty());
        assertTrue(clientDtoList.size() > 0);
    }

    @Test
    public void findAllById() {

        when(clientRepository.findById(any(Long.class)))
                .thenReturn(Optional.of(new Client()));

        service.findAllById(CLIENT_ID)
                .test()
                .assertNotCompleted()
                .assertError(MyError.class)
                .awaitTerminalEvent();

        verify(clientRepository, times(1)).findById(any(Long.class));

    }

}