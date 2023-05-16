package com.github.rsoi.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.github.rsoi.domain.Good;
import com.github.rsoi.domain.Mark;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;
@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class AllMarksResponse {

    List<Mark> marks;

    public static AllMarksResponse of(List<Mark> marks) {
        return new AllMarksResponse(marks);
    }
}