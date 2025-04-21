package org.example.toying.areas.aladin.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.toying.areas.aladin.command.BookSearchCommand;
import org.example.toying.areas.aladin.responseDto.AladinBookResponse;
import org.example.toying.client.AladinApiClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AladinService {

    private final AladinApiClient aladinApiClient;

    public List<AladinBookResponse> searchBooks(BookSearchCommand command) throws JsonProcessingException {
        String rawJson = aladinApiClient.searchBooks(command);

        // JSON 파싱 (ObjectMapper 사용해서 DTO로 매핑)
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(rawJson);
        JsonNode items = root.get("item");


//        if (items == null || !items.isArray()) {
//            System.out.println(" JSON 응답에 'item' 배열이 없음!");
//            System.out.println("실제 응답: " + rawJson);
//            return List.of(); // 또는 예외 던져도 됨
//        }
        List<AladinBookResponse> result = new ArrayList<>();
        for (JsonNode item : items) {
            AladinBookResponse aladinBookResponse = new AladinBookResponse();
            aladinBookResponse.setBookTitle(item.get("title").asText());
            aladinBookResponse.setAuthor(item.get("author").asText());
            aladinBookResponse.setCover(item.get("cover").asText());
            aladinBookResponse.setLink(item.get("link").asText());
            result.add(aladinBookResponse);
        }

        return result;
    }

}
