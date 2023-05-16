package com.github.rsoi.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.github.rsoi.domain.Greeting;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class AllGreetingsResponse {

    List<Greeting> greetings;

    public static AllGreetingsResponse of(List<Greeting> greetings) {
        return new AllGreetingsResponse(greetings);
    }
}