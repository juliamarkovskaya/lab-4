package com.github.rsoi.service;

import com.github.rsoi.dto.AllGreetingsResponse;
import com.github.rsoi.dto.CreateGreetingRequest;
import com.github.rsoi.dto.GreetingResponse;

public interface GreetingService {
    AllGreetingsResponse getAllGreetings();
    GreetingResponse getGreeting(long id);
    GreetingResponse createGreeting(CreateGreetingRequest request);
}
