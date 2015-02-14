package org.lab.service;

import java.time.LocalDate;
import java.util.Collection;

import org.junit.Assert;
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
public class ServiceExample01filterImplTest {

	@Autowired
	private ServiceExample01filter service;

	Cinema cinema = new Cinema();

	@Test
	public void getNumSessionsByDay() {
		Assert.assertNotNull(service);

		Collection<Session> sessions = cinema.getSessions();
		LocalDate date = LocalDate.of(2015, 1, 15);
		long numberSessionByDay = service.getNumSessionsByDay(sessions, date);
		Assert.assertEquals(3, numberSessionByDay);
	}

	@Test
	public void getNumSessionsFull() {
		Assert.assertNotNull(service);

		Collection<Session> sessions = cinema.getSessions();
		long numberSessionFull = service.getNumSessionsFull(sessions);
		Assert.assertEquals(1, numberSessionFull);
	}

}
