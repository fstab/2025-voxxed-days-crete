package com.example.name_generator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.example.name_generator.Gender.*;
import static com.example.name_generator.Language.*;


@RestController
public class NameResource {

    private static final Random random = new Random(0);

    private static final Map<Language, Map<Gender, List<String>>> names = Map.of(
            english, Map.of(
                    boy, List.of("Henry", "George", "Jack"),
                    girl, List.of("Abigail", "Olivia", "Lily")
            ),
            spanish, Map.of(
                    boy, List.of("Alejandro", "Diego", "Carlos"),
                    girl, List.of("Juana", "Valeria", "Esmeralda")
            ),
            german, Map.of(
                    boy, List.of("Adalbert", "Christoph", "Paul"),
                    girl, List.of("Emma", "Lina", "Liselotte")
            ),
            french, Map.of(
                    boy, List.of("Babtiste", "Pierre", "Maurice"),
                    girl, List.of("Amélie", "Céline", "Cloé")
            )
    );

    @GetMapping("/names/{language}/{gender}")
    public String suggestName(@PathVariable("language") Language language, @PathVariable("gender") Gender gender) throws InterruptedException {
        Thread.sleep(800);
        List<String> n = names.get(language).get(gender);
        return n.get(random.nextInt(n.size())) + "\n";
    }
}
