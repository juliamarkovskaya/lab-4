package com.github.rsoi.controller;

import com.github.rsoi.dto.AllGreetingsResponse;
import com.github.rsoi.dto.CreateGreetingRequest;
import com.github.rsoi.dto.GreetingResponse;
import com.github.rsoi.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GreetingController {
    private final GreetingService greetingService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public AllGreetingsResponse getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @GetMapping
    public GreetingResponse getGreetingById(@RequestParam Long greetingId) {
        return greetingService.getGreeting(greetingId);
    }

    @PostMapping
    public GreetingResponse createGreeting(@RequestBody CreateGreetingRequest request) {
        return greetingService.createGreeting(request);
    }
}
