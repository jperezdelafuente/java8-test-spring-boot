package org.lab.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.ExampleJava8Application;
import org.lab.model.Duration;
import org.lab.model.Movie;
import org.lab.model.MovieTheater;
import org.lab.model.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ExampleJava8Application.class)
public class MovieServiceImplTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MovieService movieService;

	Collection<Session> sessionCollection = new ArrayList<Session>();

	private Collection<Session> getSessionCollection() {

		Collection<Session> sessionCollection = new ArrayList<Session>();

		// Movies
		Movie movie1 = new Movie();
		movie1.setCode("1");
		movie1.setName("King kong");
		Duration duration1 = new Duration();
		duration1.setHours(3);
		duration1.setMinutes(7);
		movie1.setDuration(duration1);

		Movie movie2 = new Movie();
		movie1.setCode("2");
		movie1.setName("Blade Runner");
		Duration duration2 = new Duration();
		duration2.setHours(1);
		duration2.setMinutes(52);
		movie2.setDuration(duration2);

		Movie movie3 = new Movie();
		movie1.setCode("3");
		movie1.setName("Jurassic Park");
		Duration duration3 = new Duration();
		duration3.setHours(2);
		duration3.setMinutes(0);
		movie3.setDuration(duration3);

		// Movies Theaters
		MovieTheater movieTheater1 = new MovieTheater();
		movieTheater1.setCode("MT1");
		movieTheater1.setNumSeats(300);

		MovieTheater movieTheater2 = new MovieTheater();
		movieTheater2.setCode("MT2");
		movieTheater2.setNumSeats(126);

		MovieTheater movieTheater3 = new MovieTheater();
		movieTheater3.setCode("MT3");
		movieTheater3.setNumSeats(251);

		// Sessions
		Session session1 = new Session();
		session1.setMovieTheater(movieTheater1);
		session1.setMovie(movie1);
		LocalDate date1 = LocalDate.of(2015, 1, 15);
		date1.atTime(18, 20);
		session1.setDate(date1);
		session1.setNumSeatsSold(251);
		session1.setPrice(5.50);
		sessionCollection.add(session1);

		Session session2 = new Session();
		session2.setMovieTheater(movieTheater2);
		session2.setMovie(movie2);
		LocalDate date2 = LocalDate.of(2015, 1, 15);
		date2.atTime(19, 40);
		session2.setDate(date2);
		session2.setNumSeatsSold(126);
		session2.setPrice(6.50);
		sessionCollection.add(session2);

		Session session3 = new Session();
		session3.setMovieTheater(movieTheater3);
		session3.setMovie(movie3);
		LocalDate date3 = LocalDate.of(2015, 1, 15);
		date3.atTime(22, 10);
		session3.setDate(date3);
		session3.setNumSeatsSold(151);
		session3.setPrice(4.50);
		sessionCollection.add(session3);

		Session session4 = new Session();
		session4.setMovieTheater(movieTheater3);
		session4.setMovie(movie3);
		LocalDate date4 = LocalDate.of(2015, 1, 16);
		date4.atTime(22, 10);
		session4.setDate(date4);
		session4.setNumSeatsSold(151);
		session4.setPrice(4.50);
		sessionCollection.add(session4);

		return sessionCollection;
	}

	@Test
	public void getNumSessionsByDay() {
		logger.debug("start test getNumSessionsByDay");
		Assert.assertNotNull(movieService);

		Collection<Session> sessions = getSessionCollection();
		LocalDate date = LocalDate.of(2015, 1, 15);
		long numberSessionByDay = movieService.getNumSessionsByDay(sessions,
				date);
		Assert.assertEquals(3, numberSessionByDay);
		logger.debug("end test getNumSessionsByDay");
	}

	@Test
	public void getNumSessionsFull() {
		logger.debug("start test getNumSessionsFull");
		Assert.assertNotNull(movieService);

		Collection<Session> sessions = getSessionCollection();
		long numberSessionFull = movieService.getNumSessionsFull(sessions);
		Assert.assertEquals(1, numberSessionFull);
		logger.debug("end test getNumSessionsFull");
	}

}
