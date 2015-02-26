package org.lab.service;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.ExampleJava8Application;
import org.lab.model.Cinema;
import org.lab.model.Movie;
import org.lab.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ExampleJava8Application.class)
public class ServiceExample07forEachImplTest {

	@Autowired
	private ServiceExample07forEach service;

	Cinema cinema = new Cinema();

	@Test
	public void addDurationToSession() {
		Assert.assertNotNull(service);
		Collection<Movie> movies = cinema.getMovies();
		service.addDurationToMovies(movies, 10);

		movies.forEach(movie -> {
			switch (movie.getName()) {
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
		Assert.assertNotNull(service);
		Collection<Session> sessions = cinema.getSessions();
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
