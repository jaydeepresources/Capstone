package com.simplilearn.capstone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "cast_members")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cast {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer castId;

	private String writer;
	private String director;
	private String music;
	private String camera;
	private String actors;

	@OneToOne(mappedBy="cast")
	@JsonIgnore
	private Movie movie;

	public Cast() {
		// TODO Auto-generated constructor stub
	}

	public Cast(Integer castId, String writer, String director, String music, String camera, String actors,
			Movie movie) {
		super();
		this.castId = castId;
		this.writer = writer;
		this.director = director;
		this.music = music;
		this.camera = camera;
		this.actors = actors;
		this.movie = movie;
	}

	public Integer getCastId() {
		return castId;
	}

	public void setCastId(Integer castId) {
		this.castId = castId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Cast [castId=" + castId + ", writer=" + writer + ", director=" + director + ", music=" + music
				+ ", camera=" + camera + ", actors=" + actors + "]";
	}

}
