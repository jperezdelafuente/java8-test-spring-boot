package org.lab.model;

import java.time.LocalDate;

public class Session {

	private Integer codSession;

	private MovieTheater movieTheater;

	private Movie movie;

	private LocalDate date;

	private Integer numSeatsSold;

	private Double price;

	public Integer getCodSession() {
		return codSession;
	}

	public void setCodSession(Integer codSession) {
		this.codSession = codSession;
	}

	public MovieTheater getMovieTheater() {
		return movieTheater;
	}

	public void setMovieTheater(MovieTheater movieTheater) {
		this.movieTheater = movieTheater;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalDate getDateWithOutHour() {
		return LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getNumSeatsSold() {
		return numSeatsSold;
	}

	public void setNumSeatsSold(Integer numSeatsSold) {
		this.numSeatsSold = numSeatsSold;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTitle() {
		return movie.getTitle();
	}

	public Double getOccupationRatio() {
		return 1. * this.getNumSeatsSold() / this.getMovieTheater().getNumSeats();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Session [codSession=");
		builder.append(codSession);
		builder.append(", movieTheater=");
		builder.append(movieTheater);
		builder.append(", movie=");
		builder.append(movie);
		builder.append(", date=");
		builder.append(date);
		builder.append(", numSeatsSold=");
		builder.append(numSeatsSold);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}

}
