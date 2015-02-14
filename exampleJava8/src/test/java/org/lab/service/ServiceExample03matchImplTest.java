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
public class ServiceExample03matchImplTest {

	@Autowired
	private ServiceExample03match service;

	Cinema cinema = new Cinema();

	@Test
	public void allSessionsFull() {
		Assert.assertNotNull(service);

		Collection<Session> sessions = cinema.getSessions();
		LocalDate date = LocalDate.of(2015, 1, 15);
		Boolean exists = service.allSessionsFull(sessions, date);
		Assert.assertEquals(false, exists);
	}

	@Test
	public void existsSessionFull() {
		Assert.assertNotNull(service);

		Collection<Session> sessions = cinema.getSessions();
		LocalDate date = LocalDate.of(2015, 1, 15);
		Boolean exists = service.existsSessionFull(sessions, date);
		Assert.assertEquals(true, exists);
	}

	@Test
	public void existsSessionNotFull() {
		Assert.assertNotNull(service);

		Collection<Session> sessions = cinema.getSessions();
		LocalDate date = LocalDate.of(2015, 1, 15);
		Boolean exists = service.existsSessionNotFull(sessions, date);
		Assert.assertEquals(true, exists);
	}

}
