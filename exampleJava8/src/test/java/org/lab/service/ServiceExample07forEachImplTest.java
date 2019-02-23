package org.lab.service;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.ExampleJava8Application;
import org.lab.model.Cinema;
import org.lab.model.Movie;
import org.lab.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ExampleJava8Application.class)
public class ServiceExample07forEachImplTest {

	@Autowired
	private ServiceExample07forEach service;

	private Collection<Session> sessions = null;

	private Collection<Movie> movies = null;

	@Before
	public void initialize() {
		Assert.assertNotNull(service);
		Cinema cinema = new Cinema();
		sessions = cinema.getSessions();
		movies = cinema.getMovies();
	}

	@Test
	public void addDurationToSession() {
		service.addDurationToMovies(movies, 10);

		movies.forEach(movie -> {
			switch (movie.getTitle()) {
			case "King kong":
				Assert.assertTrue(movie.getDuration().getTotalMinutes() == 197);
				break;
			case "Blade Runner":
				Assert.assertTrue(movie.getDuration().getTotalMinutes() == 122);
				break;
			case "Jurassic Park":
				Assert.assertTrue(movie.getDuration().getTotalMinutes() == 130);
				break;
			}
		});
	}

	@Test
	public void addPercentAditionalPrice() {
		service.addPercentAditionalPrice(sessions, 10);

		sessions.forEach(session -> {
			switch (session.getCodSession()) {
			case 1:
				Assert.assertTrue(session.getPrice() == 6.05);
				break;
			case 2:
				Assert.assertTrue(session.getPrice() == 7.15);
				break;
			case 3:
				Assert.assertTrue(session.getPrice() == 4.95);
				break;
			case 4:
				Assert.assertTrue(session.getPrice() == 5.06);
				break;
			}
		});

	}
}
