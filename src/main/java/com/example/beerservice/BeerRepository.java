package com.example.beerservice;

import org.springframework.data.repository.CrudRepository;

public interface BeerRepository extends CrudRepository<Beer, Long> {

}
