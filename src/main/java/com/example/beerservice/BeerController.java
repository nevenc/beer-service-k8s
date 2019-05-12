package com.example.beerservice;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

import static java.lang.String.format;

@RestController
public class BeerController {

    private static final Logger LOG = LoggerFactory.getLogger(BeerController.class);

    private BeerRepository beerRepository;

    public BeerController(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @GetMapping("/init")
    public String initializeDatabase(@RequestParam(name = "count", defaultValue = "10") int count) {
        LOG.info("Initializing database with {} record(s).", count);

        IntStream.range(0, count).forEach(i -> {
            Beer beer = getRandomBeer();
            beerRepository.save(beer);
            LOG.debug("Adding record to database: {}", beer);
        });

        return format("Added %s record(s).", count);
    }

    @GetMapping
    public Iterable<Beer> beers() {
        return beerRepository.findAll();
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
