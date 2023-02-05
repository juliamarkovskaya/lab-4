package com.github.rsoi.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.github.rsoi.domain.Greeting;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class GreetingResponse {
    long id;
    String text;

    public static GreetingResponse of(Greeting greeting) {
        return new GreetingResponse(greeting.getId(), greeting.getText());
    }
}
