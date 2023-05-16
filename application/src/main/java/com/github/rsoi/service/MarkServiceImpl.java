package com.github.rsoi.service;

import com.github.rsoi.domain.Good;
import com.github.rsoi.domain.Mark;
import com.github.rsoi.dto.*;
import com.github.rsoi.repository.GoodRepository;
import com.github.rsoi.repository.MarkRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MarkServiceImpl implements MarkService {
    private final MarkRepository markRepository;

    @PostConstruct
    void init () {
        markRepository.findAll().stream().toList().forEach(mark -> {
            System.out.println(mark.toString());
        });
    }

    @Override
    public AllMarksResponse allMarks() {
        return AllMarksResponse.of(markRepository.findAll().stream().toList());
    }

    @Override
    public MarkResponse getMark(long id) {
        return MarkResponse.of(markRepository.getReferenceById(id));
    }

    @Override
    public MarkResponse createMark(CreateMarkRequest request) {
        var mark = new Mark();
        mark.setIdOfGood(request.getIdOfGood());
        mark.setMark(request.getMark());
        mark.setDate(request.getDate());
        return MarkResponse.of(markRepository.save(mark));
    }
}
