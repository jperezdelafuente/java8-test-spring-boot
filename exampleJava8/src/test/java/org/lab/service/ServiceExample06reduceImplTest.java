package org.lab.service;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.ExampleJava8Application;
import org.lab.model.Cinema;
import org.lab.model.Duration;
import org.lab.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ExampleJava8Application.class)
public class ServiceExample06reduceImplTest {

	@Autowired
	private ServiceExample06reduce service;

	Cinema cinema = new Cinema();

	@Test
	public void getSumDuration() {
		Assert.assertNotNull(service);
		Collection<Session> sessions = cinema.getSessions();
		Duration sumDuration = service.getSumDuration(sessions);
		Assert.assertEquals(8, sumDuration.getHours(), 0);
		Assert.assertEquals(59, sumDuration.getMinutes(), 0);
	}

	@Test
	public void getSumDurationWithBiFunction() {
		Assert.assertNotNull(service);
		Collection<Session> sessions = cinema.getSessions();
		Duration sumDuration = service.getSumDurationWithBiFunction(sessions);
		Assert.assertEquals(8, sumDuration.getHours(), 0);
		Assert.assertEquals(59, sumDuration.getMinutes(), 0);
	}

}
