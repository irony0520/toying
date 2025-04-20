package org.example.toying.areas.tmdb.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.toying.areas.tmdb.command.TmdbSearchCommand;
import org.example.toying.areas.tmdb.responseDto.TmdbResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TmdbService {


    private final TmdbSearchCommand tmdbSearchCommand; // 설정 값 제공자
    private final RestTemplate restTemplate = new RestTemplate();

    public List<TmdbResponseDto> searchMovies(String query) {

        // 1. URL 구성
        String url = String.format("%s/search/movie?api_key=%s&query=%s",
                tmdbSearchCommand.getTmdbApiUrl(), tmdbSearchCommand.getApiKey(), query);

        // 2. 외부 API 호출
        String response = restTemplate.getForObject(url, String.class);

        // 3. 결과 파싱
        List<TmdbResponseDto> resultList = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(response);
            JsonNode results = root.path("results");

            for (JsonNode node : results) {
                resultList.add(
                        TmdbResponseDto.builder()
                                .title(node.path("title").asText())
                                .overview(node.path("overview").asText())
                                .releaseDate(node.path("release_date").asText())
                                .posterPath(node.path("poster_path").asText())
                                .build()
                );
            }
        } catch (IOException e) {
            throw new RuntimeException("TMDB 응답 파싱 실패", e);
        }

        return resultList;
    }
}
