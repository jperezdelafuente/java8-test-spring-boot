package org.lab.service;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.ExampleJava8Application;
import org.lab.model.Cinema;
import org.lab.model.Duration;
import org.lab.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ExampleJava8Application.class)
public class ServiceExample06reduceImplTest {

	@Autowired
	private ServiceExample06reduce service;

	private Collection<Session> sessions = null;

	@Before
	public void initialize() {
		Assert.assertNotNull(service);
		Cinema cinema = new Cinema();
		sessions = cinema.getSessions();
	}

	@Test
	public void getSumDuration() {
		Duration sumDuration = service.getSumDuration(sessions);
		Assert.assertEquals(8, sumDuration.getHours(), 0);
		Assert.assertEquals(59, sumDuration.getMinutes(), 0);
	}

	@Test
	public void getSumDurationWithBiFunction() {
		Duration sumDuration = service.getSumDurationWithBiFunction(sessions);
		Assert.assertEquals(8, sumDuration.getHours(), 0);
		Assert.assertEquals(59, sumDuration.getMinutes(), 0);
	}

	@Test
	public void getSumDurationIncreasedWithBiFunction() {
		Duration sumDuration = service.getSumDurationIncreasedWithBiFunction(sessions, 10);
		Assert.assertEquals(7, sumDuration.getHours(), 0);
		Assert.assertEquals(29, sumDuration.getMinutes(), 0);
	}

}
