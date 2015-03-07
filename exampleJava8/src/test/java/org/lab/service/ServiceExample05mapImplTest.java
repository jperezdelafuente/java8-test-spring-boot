package org.lab.service;

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
public class ServiceExample05mapImplTest {

	@Autowired
	private ServiceExample05map service;

	private Collection<Session> sessions = null;

	@Before
	public void initialize() {
		Assert.assertNotNull(service);
		Cinema cinema = new Cinema();
		sessions = cinema.getSessions();
	}

	@Test
	public void getMaxOccupation() {
		Double occupation = service.getMaxOccupation(sessions);
		Assert.assertEquals(1, occupation.doubleValue(), 0);
	}

	@Test
	public void getSumTakings() {
		Double sumTakings = service.getSumTakings(sessions);
		Assert.assertEquals(3573.6, sumTakings.doubleValue(), 0);
	}

	@Test
	public void getAverageTakings() {
		Double averageTakings = service.getAverageTakings(sessions);
		Assert.assertEquals(893.4, averageTakings.doubleValue(), 0);
	}
}
