package com.github.rsoi.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.github.rsoi.domain.Good;
import com.github.rsoi.domain.Greeting;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class GoodResponse {
    long id;
    String Name;
    int orderAmount;
    float averageMark;


    public static GoodResponse of(Good good) {
        return new GoodResponse(good.getId(), good.getName(), good.getOrderAmount(), good.getAverageMark());
    }
}
