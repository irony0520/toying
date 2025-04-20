package org.example.toying.areas.tmdb.responseDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TmdbResponseDto {


    private String title;
    private String overview;
    private String releaseDate;
    private String posterPath;

}
