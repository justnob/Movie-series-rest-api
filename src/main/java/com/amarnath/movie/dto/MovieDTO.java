package com.amarnath.movie.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MovieDTO {

	private String id;

	private String name;

	private String description;

	private int numberOfEpisodes;

	private Date airDate;

	private Date endDate;

	private byte rating;

}
