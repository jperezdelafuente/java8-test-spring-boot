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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ExampleJava8Application.class)
public class ServiceExample03matchImplTest {

	@Autowired
	private ServiceExample03match service;

	private Collection<Session> sessions = null;

	@Before
	public void initialize() {
		Assert.assertNotNull(service);
		Cinema cinema = new Cinema();
		sessions = cinema.getSessions();
	}

	@Test
	public void allSessionsFull() {
		LocalDate date = LocalDate.of(2015, 1, 15);
		Boolean exists = service.allSessionsFull(sessions, date);
		Assert.assertEquals(false, exists);
	}

	@Test
	public void existsSessionFull() {
		LocalDate date = LocalDate.of(2015, 1, 15);
		Boolean exists = service.existsSessionFull(sessions, date);
		Assert.assertEquals(true, exists);
	}

	@Test
	public void existsSessionNotFull() {
		LocalDate date = LocalDate.of(2015, 1, 15);
		Boolean exists = service.existsSessionNotFull(sessions, date);
		Assert.assertEquals(true, exists);
	}

}
