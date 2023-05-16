package com.github.rsoi.controller;

import com.github.rsoi.dto.*;
import com.github.rsoi.service.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marks")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MarkController {
    MarkService markService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public AllMarksResponse AllMarksResponse () {
        return markService.allMarks();
    }

    @GetMapping
    public MarkResponse getMarkById(@RequestParam Long id) {
        return markService.getMark(id);
    }

    @PostMapping
    public MarkResponse createMark(@RequestBody CreateMarkRequest request) {
        return markService.createMark(request);
    }
}

