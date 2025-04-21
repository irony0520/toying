package org.example.toying.areas.aladin.command;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
    public class BookSearchCommand {
        private String keyword;
        private String queryType;
        private int maxResults;
    }


