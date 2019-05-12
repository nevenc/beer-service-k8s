package com.example.beerservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beer {

    @Id
    @Wither
    private Long id;
    private String name;
    private String hop;
    private String yeast;
    private String malt;
    private String style;

}
