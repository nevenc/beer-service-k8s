package com.example.beerservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer,Long> {
}
