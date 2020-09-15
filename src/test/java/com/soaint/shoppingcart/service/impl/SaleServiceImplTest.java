package com.soaint.shoppingcart.service.impl;

import com.soaint.shoppingcart.ShoppingCartApplication;
import com.soaint.shoppingcart.dto.SaleDto;
import com.soaint.shoppingcart.errors.exceptions.ProductException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingCartApplication.class)
public class SaleServiceImplTest implements TestConstants {

    @Autowired
    private SaleServiceImpl service;

    @Before
    public void setUp() throws Exception {
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void findOneById() throws ProductException {
        Optional<SaleDto> prod =  service.findOne(null);

    }
}