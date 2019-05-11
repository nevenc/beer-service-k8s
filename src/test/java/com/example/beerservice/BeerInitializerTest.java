package com.example.beerservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BeerInitializerTest {

    @Autowired
    private BeerInitializer beerInitializer;

    @Autowired
    private BeerRepository beerRepository;

    @Test
    public void testInitializeDatabase() {
        assertThat(beerRepository.count()).isEqualTo(0L);

        String initMessage = beerInitializer.initializeDatabase(10);

        assertThat(initMessage).contains("Added 10");
        assertThat(beerRepository.count()).isEqualTo(10L);
    }

}
