package com.amarnath.movie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String imageUrl;

	private String description;

	private int numberOfEpisodes;

	private Date airDate;

	private Date endDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rate_id")
	private Rate rating;
	
}
