package com.amarnath.movie.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MovieDTO {

	private String id;

	private String name;

	private String imageUrl;

	private String description;

	private int numberOfEpisodes;

	private AiredDTO aired;

	private RateDTO rating;

	private List<GenreDTO> genres = new ArrayList<>();

	private List<TrailerDTO> trailers = new ArrayList<>();


}
