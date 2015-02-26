package org.lab.model;

import java.time.LocalDate;
import java.util.function.Function;

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

	public Function<Session, Double> getOccupation() {
		return x -> 1. * x.getNumSeatsSold() / x.getMovieTheater().getNumSeats();
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
