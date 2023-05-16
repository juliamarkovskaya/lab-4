package com.github.rsoi.service;

import com.github.rsoi.dto.AllMarksResponse;
import com.github.rsoi.dto.CreateMarkRequest;
import com.github.rsoi.dto.MarkResponse;

public interface MarkService {
    AllMarksResponse allMarks();
    MarkResponse getMark(long id);
    MarkResponse createMark(CreateMarkRequest request);
}
