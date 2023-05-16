package com.github.rsoi.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Value;


@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class CreateMarkRequest {
    Long idOfGood;
    int mark;
    int date;
}
