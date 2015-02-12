package org.lab.service;

import java.util.Collection;
import java.util.Optional;

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
public class ServiceExample04minMaxComparatorImplTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ServiceExample04minMaxComparator service;

	Cinema cinema = new Cinema();

	@Test
	public void getSessionMinPrice() {
		logger.debug("start test getSessionMinPrice");
		Assert.assertNotNull(service);

		Collection<Session> sessions = cinema.getSessions();
		Optional<Session> session = service.getSessionMinPrice(sessions);
		Assert.assertEquals(true, session.isPresent());
		Assert.assertTrue(session.get().getMovie().getName().equals("Jurassic Park"));
		logger.debug("start end getSessionMinPrice");
	}

	@Test
	public void getSessionMaxPrice() {
		logger.debug("start test getSessionMaxPrice");
		Assert.assertNotNull(service);

		Collection<Session> sessions = cinema.getSessions();
		Optional<Session> session = service.getSessionMaxPrice(sessions);
		Assert.assertEquals(true, session.isPresent());
		Assert.assertTrue(session.get().getMovie().getName().equals("Blade Runner"));
		logger.debug("start end getSessionMaxPrice");
	}

}
