package com.github.rsoi.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.github.rsoi.domain.Good;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;
@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class AllGoodsResponse {
    List<Good> goods;

    public static AllGoodsResponse of(List<Good> goods) {
        return new AllGoodsResponse(goods);
    }
}