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
public class BeerRepositoryTest {

    @Autowired
    private BeerRepository beerRepository;

    @Test
    public void testCreate() {
        assertThat(beerRepository.count()).isEqualTo(0L);
        beerRepository.save(new Beer());
        assertThat(beerRepository.count()).isEqualTo(1L);
    }

}
