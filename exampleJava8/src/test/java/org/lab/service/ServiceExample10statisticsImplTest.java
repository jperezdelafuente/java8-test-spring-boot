package org.lab.service;

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
public class ServiceExample10statisticsImplTest {

	@Autowired
	private ServiceExample10statistics service;

	Cinema cinema = new Cinema();

	@Test
	public void getDurations() {
		Assert.assertNotNull(service);
		Collection<Session> sessions = cinema.getSessions();
		Double avergePrice = service.getAveragePrice(sessions);

		Assert.assertEquals(avergePrice, 5.275, 0);
	}

}
