package com.example.beerservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

@RestController
public class KillSwitchController {

    private static final Logger LOG = LoggerFactory.getLogger(KillSwitchController.class);

    @GetMapping("/kill")
    public String exitAbruptly() {
        LOG.info("About to kill the application.");

        new Thread(() -> {
            try {
                Thread.sleep(100L);
                System.exit(-1);
            } catch (InterruptedException e) {
                //
            }
        }).start();

        return "Killed the application.";
    }

    @GetMapping("/memory")
    public String fillUpMemory(@RequestParam(name = "count", defaultValue = "1000000") int count) {
        Map<Integer, Beer> map = new HashMap<>();
        IntStream.range(0, count).forEach(i -> map.put(i, new Beer()));

        return "Successfully created " + map.size() + " object(s)";
    }

}
