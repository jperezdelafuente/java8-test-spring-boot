package org.lab.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
public class ServiceExample08sortedImplTest {

	@Autowired
	private ServiceExample08sorted service;

	Cinema cinema = new Cinema();

	@Test
	public void getSessionSortedByPrice() {
		Assert.assertNotNull(service);
		Collection<Session> sessions = cinema.getSessions();
		Stream<Session> streamSessions = service.getSessionSortedByPrice(sessions);

		List<Session> sessionsList = streamSessions.collect(Collectors.toList());

		Assert.assertEquals(sessionsList.get(0).getCodSession().intValue(), 3);
		Assert.assertEquals(sessionsList.get(1).getCodSession().intValue(), 4);
		Assert.assertEquals(sessionsList.get(2).getCodSession().intValue(), 1);
		Assert.assertEquals(sessionsList.get(3).getCodSession().intValue(), 2);
	}

	@Test
	public void getSessionSortedByPriceDesc() {
		Assert.assertNotNull(service);
		Collection<Session> sessions = cinema.getSessions();
		Stream<Session> streamSessions = service.getSessionSortedByPriceDesc(sessions);

		List<Session> sessionsList = streamSessions.collect(Collectors.toList());

		Assert.assertEquals(sessionsList.get(0).getCodSession().intValue(), 2);
		Assert.assertEquals(sessionsList.get(1).getCodSession().intValue(), 1);
		Assert.assertEquals(sessionsList.get(2).getCodSession().intValue(), 4);
		Assert.assertEquals(sessionsList.get(3).getCodSession().intValue(), 3);
	}

	@Test
	public void getSessionSortedByDateAndPrice() {
		Assert.assertNotNull(service);
		Collection<Session> sessions = cinema.getSessions();
		Stream<Session> streamSessions = service.getSessionSortedByDateAndPrice(sessions);

		List<Session> sessionsList = streamSessions.collect(Collectors.toList());

		Assert.assertEquals(sessionsList.get(0).getCodSession().intValue(), 3);
		Assert.assertEquals(sessionsList.get(1).getCodSession().intValue(), 1);
		Assert.assertEquals(sessionsList.get(2).getCodSession().intValue(), 2);
		Assert.assertEquals(sessionsList.get(3).getCodSession().intValue(), 4);
	}
}
