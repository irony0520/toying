package org.example.toying.client;

import lombok.RequiredArgsConstructor;
import org.example.toying.areas.aladin.command.BookSearchCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@Service
public class AladinApiClient {

    @Value("${aladin.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public String searchBooks(BookSearchCommand command) {
        String url = UriComponentsBuilder
                .fromHttpUrl("http://www.aladin.co.kr/ttb/api/ItemSearch.aspx")
                .queryParam("ttbkey", apiKey)
                .queryParam("Query", command.getKeyword())
                .queryParam("QueryType", command.getQueryType())
                .queryParam("MaxResults", command.getMaxResults())
                .queryParam("SearchTarget", "Book")
                .queryParam("output", "js")
                .queryParam("Version", "20131101")
                .toUriString();

        return restTemplate.getForObject(url, String.class);
    }
}