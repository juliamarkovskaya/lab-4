package com.github.rsoi.service;

import com.github.rsoi.domain.Mark;
import com.github.rsoi.dto.AllGoodsResponse;
import com.github.rsoi.dto.CreateGoodRequest;
import com.github.rsoi.dto.GoodResponse;

import java.util.ArrayList;

public interface GoodService {
    AllGoodsResponse sortAllGoods();
    AllGoodsResponse getAllGoods();
    GoodResponse getGood(Long id);
    GoodResponse createGood(CreateGoodRequest request);

}
