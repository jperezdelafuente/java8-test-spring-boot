package org.lab.service;

import java.util.Collection;
import java.util.List;

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
public class ServiceExample09collectImplTest {

	@Autowired
	private ServiceExample09collect service;

	Cinema cinema = new Cinema();

	@Test
	public void getDurations() {
		Assert.assertNotNull(service);
		Collection<Session> sessions = cinema.getSessions();
		List<Duration> listDuration = service.getDurations(sessions);

		Assert.assertEquals(listDuration.get(0).getTotalMinutes().intValue(), 187);
		Assert.assertEquals(listDuration.get(1).getTotalMinutes().intValue(), 112);
		Assert.assertEquals(listDuration.get(2).getTotalMinutes().intValue(), 120);
		Assert.assertEquals(listDuration.get(3).getTotalMinutes().intValue(), 120);
	}
}
