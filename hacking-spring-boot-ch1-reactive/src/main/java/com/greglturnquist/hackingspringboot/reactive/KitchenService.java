package com.greglturnquist.hackingspringboot.reactive;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class KitchenService {
    Flux<Dish> getDishes() {
        return Flux.<Dish> generate(sink->sink.next(randomDish())) //
                .delayElements(Duration.ofMillis(250));
    }

    private Dish randomDish() {
        return menu.get(picker.nextInt(menu.size()));
    }

    private List<Dish> menu = Arrays.asList(
            new Dish("chicken"),
            new Dish("noodles"),
            new Dish("beef")
    );

    private Random picker = new Random();
}
