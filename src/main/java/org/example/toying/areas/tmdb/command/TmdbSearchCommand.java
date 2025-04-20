package org.example.toying.areas.tmdb.command;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import org.example.toying.areas.tmdb.responseDto.TmdbResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TmdbSearchCommand {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.url}")
    private String tmdbApiUrl;


}
