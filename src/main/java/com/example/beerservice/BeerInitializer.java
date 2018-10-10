package com.example.beerservice;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerInitializer {

    private Logger logger = LoggerFactory.getLogger(BeerInitializer.class);

    private BeerRepository beerRepository;

    public BeerInitializer(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @GetMapping("/init")
    public String inititalizeDatabase(@RequestParam(name = "count", defaultValue = "10") int count) {
        logger.info("Initializing database with " + count + " record(s).");
        for (int i = 0; i < count; i++) {
            Beer beer = getRandomBeer();
            beerRepository.save(beer);
            logger.debug("Adding record to database: " + beer);
        }
        return "Added " + count + " record(s).";
    }

    private Beer getRandomBeer() {
        return new Beer(
                null,
                Faker.instance().beer().name(),
                Faker.instance().beer().hop(),
                Faker.instance().beer().yeast(),
                Faker.instance().beer().malt(),
                Faker.instance().beer().style()
        );
    }

}
