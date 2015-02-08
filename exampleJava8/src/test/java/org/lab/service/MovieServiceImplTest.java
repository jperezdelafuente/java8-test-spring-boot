package org.lab.service;

import java.time.LocalDate;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.ExampleJava8Application;
import org.lab.model.Cinema;
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

	Cinema cinema = new Cinema();

	@Test
	public void getNumSessionsByDay() {
		logger.debug("start test getNumSessionsByDay");
		Assert.assertNotNull(movieService);

		Collection<Session> sessions = cinema.getSessions();
		LocalDate date = LocalDate.of(2015, 1, 15);
		long numberSessionByDay = movieService.getNumSessionsByDay(sessions, date);
		Assert.assertEquals(3, numberSessionByDay);
		logger.debug("end test getNumSessionsByDay");
	}

	@Test
	public void getNumSessionsByDayPredicate() {
		logger.debug("start test getNumSessionsByDayPredicate");
		Assert.assertNotNull(movieService);

		Collection<Session> sessions = cinema.getSessions();
		LocalDate date = LocalDate.of(2015, 1, 15);
		long numberSessionByDay = movieService.getNumSessionsByDayPredicate(sessions, date);
		Assert.assertEquals(3, numberSessionByDay);
		logger.debug("end test getNumSessionsByDayPredicate");
	}

	@Test
	public void getNumSessionsFull() {
		logger.debug("start test getNumSessionsFull");
		Assert.assertNotNull(movieService);

		Collection<Session> sessions = cinema.getSessions();
		long numberSessionFull = movieService.getNumSessionsFull(sessions);
		Assert.assertEquals(1, numberSessionFull);
		logger.debug("end test getNumSessionsFull");
	}

}
