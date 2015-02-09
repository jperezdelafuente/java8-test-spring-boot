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
public class ServiceExample02predicateImplTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ServiceExample02predicate service;

	Cinema cinema = new Cinema();

	@Test
	public void getNumSessionsByDayPredicate() {
		logger.debug("start test getNumSessionsByDayPredicate");
		Assert.assertNotNull(service);

		Collection<Session> sessions = cinema.getSessions();
		LocalDate date = LocalDate.of(2015, 1, 15);
		long numberSessionByDay = service.getNumSessionsByDayPredicate(sessions, date);
		Assert.assertEquals(3, numberSessionByDay);
		logger.debug("end test getNumSessionsByDayPredicate");
	}

	@Test
	public void getNumSessionsFullByDayPredicate() {
		logger.debug("start test getNumSessionsFullByDayPredicate");
		Assert.assertNotNull(service);

		Collection<Session> sessions = cinema.getSessions();
		LocalDate date = LocalDate.of(2015, 1, 15);
		long numberSessionByDay = service.getNumSessionsFullByDayPredicate(sessions, date);
		Assert.assertEquals(1, numberSessionByDay);
		logger.debug("end test getNumSessionsFullByDayPredicate");
	}

}
