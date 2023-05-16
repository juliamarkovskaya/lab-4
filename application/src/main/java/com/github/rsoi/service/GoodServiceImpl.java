package com.github.rsoi.service;

import com.github.rsoi.domain.Good;
import com.github.rsoi.domain.Greeting;
import com.github.rsoi.domain.Mark;
import com.github.rsoi.dto.*;
import com.github.rsoi.repository.GoodRepository;
import com.github.rsoi.repository.MarkRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class GoodServiceImpl implements GoodService {
    private final GoodRepository goodRepository;
    private final MarkRepository markRepository;
    private final Random random = new Random();


//    @PostConstruct
//    void init() {
//        goodRepository.deleteAll();
//    }

    private ArrayList<Mark> getMarksById (long id) {
        //markRepository.findById()
        var marks = markRepository.findAll().stream().toList();
        ArrayList<Mark> res = new ArrayList<>();
        marks.forEach(mark -> {
            if (mark.getIdOfGood() == id) res.add(mark);
        });

        return res;
    }

    @Override
    public GoodResponse createGood(CreateGoodRequest request) {
        var goods = goodRepository.findAll().stream().toList();

        var good = new Good();
        // id должна генерировать бд
        good.setId(Integer.toUnsignedLong(goods.size()));
        good.setName(request.getName());
        good.setOrderAmount(request.getOrderAmount());

        // создать контроллер для создания отметки
        int amount = random.nextInt(15) + 1;
        long id = good.getId();

        for (int i = 0; i < amount; i++) {
            var mark = new Mark();
            mark.setIdOfGood(id);
            mark.setMark(random.nextInt(5));
            mark.setDate(random.nextInt(11) + 1);
            markRepository.save(mark);
        }

        good.setAverageMark(good.getAverageMark(4, getMarksById(good.getId())));


        var res = goodRepository.save(good);
        return GoodResponse.of(res);
    }

    @Override
    public AllGoodsResponse sortAllGoods() {
        var goodsSort = new ArrayList<>(goodRepository.findAll().stream().toList());

        goodsSort.sort((o1, o2) ->
            Float.compare(o1.getAverageMark(4, getMarksById(o1.getId())), o2.getAverageMark(4, getMarksById(o2.getId())))
        );

        return AllGoodsResponse.of(goodsSort);
    }

    @Override
    public AllGoodsResponse getAllGoods() {
        return AllGoodsResponse.of(goodRepository.findAll().stream().toList());
    }

    @Override
    public GoodResponse getGood(Long id) {
        return GoodResponse.of(goodRepository.getReferenceById(id));
    }
}