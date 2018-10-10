package com.example.beerservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class KillSwitch {

    private Logger logger = LoggerFactory.getLogger(KillSwitch.class);

    @GetMapping("/kill")
    public String exitAbruptly() {
        logger.info("About to kill the application.");
        System.exit(-1);
        return "Should have killed the application.";
    }

    @GetMapping("/memory")
    public String fillUpMemory(@RequestParam(name = "count", defaultValue = "1000000") int count) {
        Map<Integer, Beer> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            map.put(i, new Beer());
        }
        return "Successfully created " + map.size() + " object(s)";
    }
}
