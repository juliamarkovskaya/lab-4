package com.github.rsoi.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.github.rsoi.domain.Mark;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class MarkResponse {
    Long id;
    Long idOfGood;
    int mark;
    int month;

    public static MarkResponse of(Mark mark) {
        return new MarkResponse(mark.getId(), mark.getIdOfGood(), mark.getMark(), mark.getDate());
    }
}