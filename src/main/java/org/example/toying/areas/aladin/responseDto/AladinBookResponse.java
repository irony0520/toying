package org.example.toying.areas.aladin.responseDto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AladinBookResponse {


    private String bookTitle;
    private String author;
    private String cover;
    private String link;
}
