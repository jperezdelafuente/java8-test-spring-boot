package org.lab.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Cinema {

	Collection<Session> sessions = null;

	Collection<Movie> movies = null;

    Collection<MovieTheater> movieTheaters = null;

	public Cinema() {

		sessions = new ArrayList<Session>();
		movies = new ArrayList<Movie>();
        movieTheaters = new ArrayList<MovieTheater>();

		// Movies
		Movie movie1 = new Movie();
		movie1.setCode("1");
		movie1.setTitle("King kong");
		Duration duration1 = new Duration();
		duration1.setHours(3);
		duration1.setMinutes(7);
		movie1.setDuration(duration1);
		movies.add(movie1);

		Movie movie2 = new Movie();
		movie2.setCode("2");
		movie2.setTitle("Blade Runner");
		Duration duration2 = new Duration();
		duration2.setHours(1);
		duration2.setMinutes(52);
		movie2.setDuration(duration2);
		movies.add(movie2);

		Movie movie3 = new Movie();
		movie3.setCode("3");
		movie3.setTitle("Jurassic Park");
		Duration duration3 = new Duration();
		duration3.setHours(2);
		duration3.setMinutes(0);
		movie3.setDuration(duration3);
		movies.add(movie3);

		// Movies Theaters
		MovieTheater movieTheater1 = new MovieTheater();
		movieTheater1.setCode("MT1");
		movieTheater1.setNumSeats(300);
        movieTheater1.setNumLights(20);
        movieTheater1.setNumSpeakers(8);
        movieTheater1.setNumLitterbins(6);
        movieTheaters.add(movieTheater1);

		MovieTheater movieTheater2 = new MovieTheater();
		movieTheater2.setCode("MT2");
		movieTheater2.setNumSeats(126);
        movieTheater2.setNumLights(16);
        movieTheater2.setNumSpeakers(4);
        movieTheater2.setNumLitterbins(3);
        movieTheaters.add(movieTheater2);

		MovieTheater movieTheater3 = new MovieTheater();
		movieTheater3.setCode("MT3");
		movieTheater3.setNumSeats(251);
        movieTheater3.setNumLights(22);
        movieTheater3.setNumSpeakers(6);
        movieTheater3.setNumLitterbins(4);
        movieTheaters.add(movieTheater3);

		// Sessions
		Session session1 = new Session();
		session1.setCodSession(1);
		session1.setMovieTheater(movieTheater1);
		session1.setMovie(movie1);
		LocalDate date1 = LocalDate.of(2015, 1, 15);
		date1.atTime(18, 20);
		session1.setDate(date1);
		session1.setNumSeatsSold(251);
		session1.setPrice(5.50);
		sessions.add(session1);

		Session session2 = new Session();
		session2.setCodSession(2);
		session2.setMovieTheater(movieTheater2);
		session2.setMovie(movie2);
		LocalDate date2 = LocalDate.of(2015, 1, 15);
		date2.atTime(19, 40);
		session2.setDate(date2);
		session2.setNumSeatsSold(126);
		session2.setPrice(6.50);
		sessions.add(session2);

		Session session3 = new Session();
		session3.setCodSession(3);
		session3.setMovieTheater(movieTheater3);
		session3.setMovie(movie3);
		LocalDate date3 = LocalDate.of(2015, 1, 15);
		date3.atTime(22, 10);
		session3.setDate(date3);
		session3.setNumSeatsSold(151);
		session3.setPrice(4.50);
		sessions.add(session3);

		Session session4 = new Session();
		session4.setCodSession(4);
		session4.setMovieTheater(movieTheater3);
		session4.setMovie(movie3);
		LocalDate date4 = LocalDate.of(2015, 1, 16);
		date4.atTime(22, 10);
		session4.setDate(date4);
		session4.setNumSeatsSold(151);
		session4.setPrice(4.60);
		sessions.add(session4);

	}

	public Collection<Session> getSessions() {
		return sessions;
	}

	public Collection<Movie> getMovies() {
		return movies;
	}

    public Collection<MovieTheater> getMovieTheaters() {
        return movieTheaters;
    }

}
