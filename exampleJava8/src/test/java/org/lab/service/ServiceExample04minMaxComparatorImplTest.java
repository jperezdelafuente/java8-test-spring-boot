package org.lab.service;

import java.util.Collection;
import java.util.Optional;

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
public class ServiceExample04minMaxComparatorImplTest {

	@Autowired
	private ServiceExample04minMaxComparator service;

	Cinema cinema = new Cinema();

	@Test
	public void getSessionMinPrice() {
		Assert.assertNotNull(service);

		Collection<Session> sessions = cinema.getSessions();
		Optional<Session> session = service.getSessionMinPrice(sessions);
		Assert.assertEquals(true, session.isPresent());
		Assert.assertTrue(session.get().getMovie().getName().equals("Jurassic Park"));
	}

	@Test
	public void getSessionMaxPrice() {
		Assert.assertNotNull(service);

		Collection<Session> sessions = cinema.getSessions();
		Optional<Session> session = service.getSessionMaxPrice(sessions);
		Assert.assertEquals(true, session.isPresent());
		Assert.assertTrue(session.get().getMovie().getName().equals("Blade Runner"));
	}

}
