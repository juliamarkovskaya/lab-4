package com.github.rsoi.controller;

import com.github.rsoi.domain.Good;
import com.github.rsoi.dto.*;
import com.github.rsoi.service.GoodService;
import com.github.rsoi.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GoodController {
    private final GoodService goodService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public AllGoodsResponse getAllGoods() {
        return goodService.getAllGoods();
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    @ResponseBody
    public AllGoodsResponse sortAllGoods() {
        return goodService.sortAllGoods();
    }

    @GetMapping
    public GoodResponse getGoodById(@RequestParam Long id) {
        return goodService.getGood(id);
    }

    @PostMapping
    public GoodResponse createGood(@RequestBody CreateGoodRequest request) {
        return goodService.createGood(request);
    }
}
