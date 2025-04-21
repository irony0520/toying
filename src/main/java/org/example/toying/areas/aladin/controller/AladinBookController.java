package org.example.toying.areas.aladin.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.example.toying.areas.aladin.command.BookSearchCommand;
import org.example.toying.areas.aladin.responseDto.AladinBookResponse;
import org.example.toying.areas.aladin.service.AladinService;
import org.example.toying.areas.tmdb.responseDto.TmdbResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/aladin")

public class AladinBookController {

    private final AladinService aladinService;

//    @GetMapping("/search")
//    public List<AladinBookResponse> searchBooks(@ModelAttribute BookSearchCommand command) throws JsonProcessingException {
//        return aladinService.searchBooks(command);
//    }

    @GetMapping("/search")
    public List<AladinBookResponse> searchBooks(@RequestParam String keyword) throws JsonProcessingException {
        BookSearchCommand command = new BookSearchCommand(keyword, "Title", 5);
        return aladinService.searchBooks(command);
    }
}
