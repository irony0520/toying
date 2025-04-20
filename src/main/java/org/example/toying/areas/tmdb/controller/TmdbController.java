package org.example.toying.areas.tmdb.controller;

import lombok.RequiredArgsConstructor;
import org.example.toying.areas.tmdb.command.TmdbSearchCommand;
import org.example.toying.areas.tmdb.responseDto.TmdbResponseDto;
import org.example.toying.areas.tmdb.service.TmdbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tmbs")
public class TmdbController {

    private final TmdbService tmdbService;


    @GetMapping("/search")
    public List<TmdbResponseDto> searchMovies(@RequestParam String query) {
        return tmdbService.searchMovies(query);
    }

}
