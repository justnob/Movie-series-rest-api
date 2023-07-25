package com.amarnath.movie.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MovieDTO {

	private String id;

	private String name;

	private String imageUrl;

	private String description;

	private int numberOfEpisodes;

	private Date airDate;

	private Date endDate;

	private float rating;


}
