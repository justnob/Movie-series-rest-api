package com.amarnath.movie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aired_id")
	private Aired aired;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rate_id")
	private Rate rating;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	private List<Genre> genres = new ArrayList<>();

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	private List<Trailer> trailers = new ArrayList<>();
	
}
