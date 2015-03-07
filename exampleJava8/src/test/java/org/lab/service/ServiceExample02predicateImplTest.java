package org.lab.service;

import java.time.LocalDate;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.ExampleJava8Application;
import org.lab.model.Cinema;
import org.lab.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ExampleJava8Application.class)
public class ServiceExample02predicateImplTest {

	@Autowired
	private ServiceExample02predicate service;

	private Collection<Session> sessions = null;

	@Before
	public void initialize() {
		Assert.assertNotNull(service);
		Cinema cinema = new Cinema();
		sessions = cinema.getSessions();
	}

	@Test
	public void getNumSessionsByDayPredicate() {
		LocalDate date = LocalDate.of(2015, 1, 15);
		long numberSessionByDay = service.getNumSessionsByDayPredicate(sessions, date);
		Assert.assertEquals(3, numberSessionByDay);
	}

	@Test
	public void getNumSessionsFullByDayPredicate() {
		LocalDate date = LocalDate.of(2015, 1, 15);
		long numberSessionByDay = service.getNumSessionsFullByDayPredicate(sessions, date);
		Assert.assertEquals(1, numberSessionByDay);
	}

}
