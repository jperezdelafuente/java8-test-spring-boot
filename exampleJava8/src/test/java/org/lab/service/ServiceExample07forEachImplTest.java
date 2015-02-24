package org.lab.service;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.ExampleJava8Application;
import org.lab.model.Cinema;
import org.lab.model.Movie;
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
			if (movie.getName().equals("King kong")) {
				Assert.assertTrue(movie.getDuration().getTotalMinutes() == 197);
			} else {
				if (movie.getName().equals("Blade Runner")) {
					Assert.assertTrue(movie.getDuration().getTotalMinutes() == 122);
				} else {
					if (movie.getName().equals("Jurassic Park")) {
						Assert.assertTrue(movie.getDuration().getTotalMinutes() == 130);
					}
				}

			}
		});
	}
}
